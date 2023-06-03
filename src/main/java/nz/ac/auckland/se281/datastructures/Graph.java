package nz.ac.auckland.se281.datastructures;

import java.util.HashSet;
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
    Set<T> graphRoots = new HashSet<>();

    // Check for in degree of 0.
    for (T vertex : verticies) {
      int inDegree = 0;
      for (Edge<T> edge : edges) {
        if (edge.getDestination() == vertex) {
          inDegree++;
        }
      }
      if (inDegree == 0) {
        graphRoots.add(vertex);
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
          graphRoots.add(vertex);
        }
      }
    }
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
    // TODO: Task 2.
    throw new UnsupportedOperationException();
  }

  public List<T> iterativeDepthFirstSearch() {
    // TODO: Task 2.
    throw new UnsupportedOperationException();
  }

  public List<T> recursiveBreadthFirstSearch() {
    // TODO: Task 3.
    throw new UnsupportedOperationException();
  }

  public List<T> recursiveDepthFirstSearch() {
    // TODO: Task 3.
    throw new UnsupportedOperationException();
  }
}
