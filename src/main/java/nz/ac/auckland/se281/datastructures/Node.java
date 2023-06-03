package nz.ac.auckland.se281.datastructures;

import java.util.ArrayList;
import java.util.List;

public class Node <T> {
    private T data;
    private Node<T> next;
    private Node<T> previous;

    public Node(T data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrev() {
        return previous;
    }

    public void setPrev(Node<T> prev) {
        this.previous = prev;
    }

    @Override
    public String toString() {
        return data.toString();
    }

    // public List<T> getNeighbours(T vertex) {
    //     // Returns a list of all the neighbours of a vertex.
    //     List<T> neighbours = new ArrayList<>();
    //     for (Edge<T> edge : edges) {
    //       if (edge.getSource() == vertex) {
    //         neighbours.add(edge.getDestination());
    //       }
    //     }
    //     return neighbours;
    //   }
    
}