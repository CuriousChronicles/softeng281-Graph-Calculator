package nz.ac.auckland.se281.datastructures;

/**
 * This class represents a node of generic type T used in data structures like linked lists, stacks,
 * and queues.
 *
 * @param <T> The type of element held in this node.
 */
public class Node<T> {
  private T data;
  private Node<T> next;
  private Node<T> previous;

  /**
   * Constructs a node with the specified data.
   *
   * @param data The data to be stored in the node.
   */
  public Node(T data) {
    this.data = data;
    this.next = null;
    this.previous = null;
  }

  /**
   * Returns the data stored in this node.
   *
   * @return The data stored in this node.
   */
  public T getData() {
    return data;
  }

  /**
   * Sets the data stored in this node.
   *
   * @param data The data to be stored in this node.
   */
  public void setData(T data) {
    this.data = data;
  }

  /**
   * Returns the next node linked to this node.
   *
   * @return The next node linked to this node.
   */
  public Node<T> getNext() {
    return next;
  }

  /**
   * Sets the next node linked to this node.
   *
   * @param next The node to be linked as the next node.
   */
  public void setNext(Node<T> next) {
    this.next = next;
  }

  /**
   * Returns the previous node linked to this node.
   *
   * @return The previous node linked to this node.
   */
  public Node<T> getPrev() {
    return previous;
  }

  /**
   * Sets the previous node linked to this node.
   *
   * @param prev The node to be linked as the previous node.
   */
  public void setPrev(Node<T> prev) {
    this.previous = prev;
  }

  /**
   * Returns a string representation of this node, which is the string representation of the data
   * stored in the node.
   *
   * @return A string representation of the node.
   */
  @Override
  public String toString() {
    return data.toString();
  }
}
