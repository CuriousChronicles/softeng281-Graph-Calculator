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

  public Graph(Set<T> verticies, Set<Edge<T>> edges) {
    this.verticies = verticies;
    this.edges = edges;
  }

  public Set<T> getRoots() {
    // Roots when the number of in degrees is 0 or the lowest equivalent vertex.
    List<T> rootList = new ArrayList<>();

    // Check for in degree of 0.
    for (T vertex : verticies) {
      int inDegree = 0;
      for (Edge<T> edge : edges) {
        if (edge.getDestination() == vertex) {
          inDegree++;
        }
      }
      if (inDegree == 0) {
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

  public boolean isEquivalence() {
    // Is equivalence when it is reflexive, symmetric and transitive.
    if (isReflexive() && isSymmetric() && isTransitive()) {
      return true;
    } else {
      return false;
    }
  }

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

  public List<T> recursiveBreadthFirstSearch() {
    Queue<T> queue = new Queue<>();
    List<T> path = new ArrayList<>();
    List<T> visited = new ArrayList<>();
    Set<T> roots = getRoots();
    // Load first vertex into the queue.
    for (T root : roots) {
      queue.enqueue(root);
      visited.add(root);

      BFSrecursive(queue, visited, path);
    }
    return path;
  }

  public void BFSrecursive(Queue<T> queue, List<T> visited, List<T> path) {
    if (queue.isEmpty()) {
      return;
    }
    T vertex = queue.dequeue();
    // visited.add(vertex);
    path.add(vertex);

    List<T> neighbours = getNeighbours(vertex);
    // sort the neighbours in ascending order.
    neighbours = sortList(neighbours);

    for (T neighbour : getNeighbours(vertex)) {
      if (!visited.contains(neighbour)) {
        queue.enqueue(neighbour);
        visited.add(neighbour);
      }
    }

    BFSrecursive(queue, visited, path);
  }

  public List<T> recursiveDepthFirstSearch() {
    // TODO: Task 3.
    throw new UnsupportedOperationException();
  }

}
