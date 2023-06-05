package nz.ac.auckland.se281.datastructures;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * A graph that is composed of a set of verticies and edges.
 *
 * <p>You must NOT change the signature of the existing methods or constructor of this class.
 *
 * @param <T> The type of each vertex, that have a total ordering.
 */
public class Graph<T extends Comparable<T>> {
  private Set<T> verticies;
  private Set<Edge<T>> edges;

  /**
   * Constructs a new graph with the given verticies and edges.
   *
   * @param verticies The verticies of the graph.
   * @param edges The edges of the graph.
   */
  public Graph(Set<T> verticies, Set<Edge<T>> edges) {
    this.verticies = verticies;
    this.edges = edges;
  }

  /**
   * Returns the roots of the graph.
   *
   * @return The roots of the graph.
   */
  public Set<T> getRoots() {
    // Roots when the number of in degrees is 0 or the lowest equivalent vertex.
    List<T> rootList = new ArrayList<>();

    // Check for in degree of 0.
    for (T vertex : verticies) {
      int inDegree = 0;
      int outDegree = 0;
      for (Edge<T> edge : edges) {
        if (edge.getDestination().equals(vertex)) {
          inDegree++;
        }
        if (edge.getSource().equals(vertex)) {
          outDegree++;
        }
      }
      if ((inDegree == 0) && (outDegree > 0)) {
        rootList.add(vertex);
      }
    }

    // Check for lowest equivalent vertex
    if (isEquivalence()) {
      for (T vertex : verticies) {
        boolean isLowest = true;
        Set<T> equivalenceClass = getEquivalenceClass(vertex);
        for (T vertex2 : equivalenceClass) {
          if (vertex.compareTo(vertex2) > 0) {
            isLowest = false;
          }
        }
        if (isLowest) {
          rootList.add(vertex);
        }
      }
    }

    rootList = sortList(rootList);
    // Convert list to set.
    Set<T> graphRoots = new LinkedHashSet<>(rootList);
    return graphRoots;
  }

  /**
   * Returns if the graph is reflexive.
   *
   * @return If the graph is reflexive.
   */
  public boolean isReflexive() {
    // Is reflexive when every vertex has a self loop.
    int reflexiveCount = 0;
    for (T vertex : verticies) {
      for (Edge<T> edge : edges) {
        if ((edge.getSource() == vertex) && (edge.getDestination() == vertex)) {
          reflexiveCount++;
        }
      }
    }
    if (reflexiveCount == verticies.size()) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Returns if the graph is symmetric.
   *
   * @return If the graph is symmetric.
   */
  public boolean isSymmetric() {
    // Is symmetric when for every edge (u, v) there is an edge (v, u).
    for (Edge<T> edge : edges) {
      if (edges.contains(new Edge<T>(edge.getDestination(), edge.getSource()))) {
        continue;
      } else {
        return false;
      }
    }
    return true;
  }

  /**
   * Returns if the graph is transitive.
   *
   * @return If the graph is transitive.
   */
  public boolean isTransitive() {
    // Is transitive when for every edge (u, v) and (v, w) there is an edge (u, w).
    for (Edge<T> edge : edges) {
      for (Edge<T> edge2 : edges) {
        if (edge.getDestination() == edge2.getSource()) {
          if (edges.contains(new Edge<T>(edge.getSource(), edge2.getDestination()))) {
            continue;
          } else {
            return false;
          }
        }
      }
    }
    return true;
  }

  /**
   * Returns if the graph is anti-symmetric.
   *
   * @return If the graph is anti-symmetric.
   */
  public boolean isAntiSymmetric() {
    // Is Antisymmetric when for every edge (u, v) and (v, u) then u = v.
    for (Edge<T> edge : edges) {
      if (edges.contains(new Edge<T>(edge.getDestination(), edge.getSource()))) {
        if (edge.getDestination() == edge.getSource()) {
          continue;
        } else {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * Returns if the graph is equivalent.
   *
   * @return If the graph is equivalent.
   */
  public boolean isEquivalence() {
    // Is equivalence when it is reflexive, symmetric and transitive.
    if (isReflexive() && isSymmetric() && isTransitive()) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Returns the equivalence class of the given vertex.
   *
   * @param vertex A vertex in the graph.
   * @return The equivalence class of the given vertex.
   */
  public Set<T> getEquivalenceClass(T vertex) {
    // The equivalence class of a vertex is the set of all verticies that are equivalent to it.
    Set<T> equivalenceClass = new HashSet<>();
    if (isEquivalence()) {
      for (T vertex2 : verticies) {
        if (vertex2 != vertex) {
          if (edges.contains(new Edge<T>(vertex, vertex2))) {
            equivalenceClass.add(vertex2);
          }
        }
      }
    }
    return equivalenceClass;
  }

  /**
   * Returns a list of a breadth first search of the graph.
   *
   * @return A list of a breadth first search of the graph.
   */
  public List<T> iterativeBreadthFirstSearch() {
    // Need to implement this with O(1) using linked list.

    Queue<T> queue = new Queue<>();
    List<T> visited = new ArrayList<>();
    List<T> path = new ArrayList<>();
    Set<T> roots = getRoots();

    if (roots.size() == 0) {
      return path;
    } else {
      // Initialise the queue with the roots.
      for (T root : roots) {
        queue.enqueue(root);
        visited.add(root);
        while (!queue.isEmpty()) {
          // Dequeue the first vertex
          T vertex = queue.dequeue();
          path.add(vertex);

          // Add all the neighbours of the vertex to the queue.
          for (T neighbour : getNeighbours(vertex)) {
            System.out.println(getNeighbours(vertex));
            if (!visited.contains(neighbour)) {
              queue.enqueue(neighbour);
              visited.add(neighbour);
            }
          }
        }
      }
    }
    return path;
  }

  /**
   * Returns a list of neighbours of a vertex.
   *
   * @param vertex A vertex in the graph.
   * @return A list of neighbours of a vertex.
   */
  public List<T> getNeighbours(T vertex) {
    // Returns a list of all the neighbours of a vertex.
    List<T> neighbours = new ArrayList<>();
    for (Edge<T> edge : edges) {
      if (edge.getSource() == vertex) {
        neighbours.add(edge.getDestination());
      }
    }

    neighbours = sortList(neighbours);
    return neighbours;
  }

  /**
   * Returns a sorted list.
   *
   * @param list A list to be sorted.
   * @return A sorted list.
   */
  public List<T> sortList(List<T> list) {
    // Sorts a list in ascending order using bubble sort.
    for (int i = 0; i < list.size() - 1; i++) {
      for (int j = 0; j < list.size() - i - 1; j++) {
        T element1 = list.get(j);
        T element2 = list.get(j + 1);
        Integer e1 = Integer.parseInt(element1.toString());
        Integer e2 = Integer.parseInt(element2.toString());

        if (e1 > e2) {
          // swap neighbours[j+1] and neighbours[i]
          T temp = list.get(j);
          list.set(j, list.get(j + 1));
          list.set(j + 1, temp);
        }
      }
    }
    return list;
  }

  /**
   * Returns a list of a depth first search of the graph.
   *
   * @return A list of a depth first search of the graph.
   */
  public List<T> iterativeDepthFirstSearch() {
    Stack<T> stack = new Stack<>();
    List<T> visited = new ArrayList<>();
    List<T> path = new ArrayList<>();
    Set<T> roots = getRoots();

    if (roots.size() == 0) {
      return path;
    } else {
      // Initialise the stack with the roots.
      for (T root : roots) {
        stack.push(root);

        while (!stack.isEmpty()) {
          // Pop a node from the stack
          T vertex = stack.pop();
          if (!visited.contains(vertex)) {
            visited.add(vertex);
            path.add(vertex);

            // push all the unvisted neighbours of the vertex to the stack
            List<T> neighbours = getNeighbours(vertex);
            // Sort the neighbours in acending order.
            neighbours = sortList(neighbours);

            for (int i = neighbours.size() - 1; i >= 0; i--) {
              if (!visited.contains(neighbours.get(i))) {
                stack.push(neighbours.get(i));
              }
            }
          }
        }
      }
    }

    return path;
  }

  /**
   * Returns a list of a breadth first search of the graph resursively.
   *
   * @return A list of a breadth first search of the graph resursively.
   */
  public List<T> recursiveBreadthFirstSearch() {
    Queue<T> queue = new Queue<>();
    List<T> path = new ArrayList<>();
    List<T> visited = new ArrayList<>();
    Set<T> roots = getRoots();

    // Load first vertex into the queue.
    for (T root : roots) {
      queue.enqueue(root);
      visited.add(root);

      recursiveBreadthSearchHelper(queue, visited, path);
    }
    return path;
  }

  /**
   * Performs a breadth first search of the graph recursively.
   *
   * @param queue A queue of vertices.
   * @param visited A list of visited vertices.
   * @param path A list of vertices in the order they were visited.
   */
  public void recursiveBreadthSearchHelper(Queue<T> queue, List<T> visited, List<T> path) {
    if (queue.isEmpty()) {
      return;
    }
    T vertex = queue.dequeue();
    path.add(vertex);

    List<T> neighbours = getNeighbours(vertex);
    // sort the neighbours in ascending order.
    neighbours = sortList(neighbours);

    for (T neighbour : neighbours) {
      if (!visited.contains(neighbour)) {
        queue.enqueue(neighbour);
        visited.add(neighbour);
      }
    }

    recursiveBreadthSearchHelper(queue, visited, path);
  }

  /**
   * Returns a list of depth first search of the graph recursively.
   *
   * @return A list of depth first search of the graph recursively.
   */
  public List<T> recursiveDepthFirstSearch() {
    Stack<T> stack = new Stack<>();
    List<T> visited = new ArrayList<>();
    List<T> path = new ArrayList<>();
    Set<T> roots = getRoots();

    // Initialise the stack with the roots.
    for (T root : roots) {
      stack.push(root);
      visited.add(root);
      recursiveDepthSearchHelper(stack, visited, path);
    }

    return path;
  }

  /**
   * Performs a depth first search of the graph recursively.
   *
   * @param stack A stack of vertices.
   * @param visited A list of visited vertices.
   * @param path A list of vertices in the order they were visited.
   */
  public void recursiveDepthSearchHelper(Stack<T> stack, List<T> visited, List<T> path) {
    // Base case
    if (stack.isEmpty()) {
      return;
    }

    T vertex = stack.pop();
    path.add(vertex);

    List<T> neighbours = getNeighbours(vertex);
    // sort the neighbours in ascending order.
    neighbours = sortList(neighbours);

    for (int i = neighbours.size() - 1; i >= 0; i--) {
      if (!visited.contains(neighbours.get(i))) {
        stack.push(neighbours.get(i));
        visited.add(neighbours.get(i));
      }
    }
    recursiveDepthSearchHelper(stack, visited, path);
  }
}