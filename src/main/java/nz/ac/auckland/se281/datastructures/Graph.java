package nz.ac.auckland.se281.datastructures;

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
    // TODO: Task 1.
    throw new UnsupportedOperationException();
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
      for (Edge<T> i : edges) {
        if ((edge.getSource() == i.getDestination()) && (edge.getDestination() == i.getSource())) {
          continue;
        } else {
          return false;
        }
      }
    }
    return true;
  }

  public boolean isTransitive() {
    // Is transitive when for every edge (u, v) and (v, w) there is an edge (u, w).
    throw new UnsupportedOperationException();
  }

  public boolean isAntiSymmetric() {
    // Is Antisymmetric when for every edge (u, v) and (v, u) then u = v.
    throw new UnsupportedOperationException();
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
    throw new UnsupportedOperationException();
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
