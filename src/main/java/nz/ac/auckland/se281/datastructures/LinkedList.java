package nz.ac.auckland.se281.datastructures;

/**
 * This class represents a doubly linked list of generic type T.
 *
 * @param <T> The type of elements held in this collection.
 */
public class LinkedList<T> {
  private int size;
  private Node<T> head;
  private Node<T> tail;

  /** Constructs an empty list. */
  public LinkedList() {
    this.size = 0;
    this.head = null;
    this.tail = null;
  }

  /**
   * Appends the specified element to the end of this list.
   *
   * @param data element to be appended to this list
   */
  public void add(T data) {
    Node<T> newNode = new Node<>(data);
    // When the size is 0, the head and tail are the same
    if (size == 0) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      newNode.setPrev(tail);
      tail.setNext(newNode);
      tail = newNode;
    }
    size++;
  }

  /**
   * Returns the element at the specified position in this list.
   *
   * @param index index of the element to return
   * @return the element at the specified position in this list
   * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
   */
  public T get(int index) {
    // Gets the value of the node at a specific index
    // Will have a current node that starts at the head and moves through the linked list until it
    // reaches the index
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    Node<T> currentNode = head;
    for (int i = 0; i < index; i++) {
      currentNode = currentNode.getNext();
    }
    return currentNode.getData();
  }

  /**
   * Inserts the specified element at the specified position in this list.
   *
   * @param index index at which the specified element is to be inserted
   * @param data element to be inserted
   * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
   */
  public void insert(int index, T data) {
    // Inserts a node at a specific index
    // If index is out of bounds, throw an exception
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }
    // If index is 0, set the head to the new node
    if (index == 0) {
      Node<T> newNode = new Node<>(data);
      head.setNext(newNode);
      newNode.setPrev(head);
      head = newNode;
    } else if (index == size) {
      // If index is the size, set the tail to the new node
      Node<T> newNode = new Node<>(data);
      tail.setNext(newNode);
      newNode.setPrev(tail);
      tail = newNode;
    } else {
      // Otherwise, set the previous node's next to the new node and the current node's previous to
      // the new node
      Node<T> newNode = new Node<>(data);
      Node<T> currentNode = head;
      for (int i = 0; i < index; i++) {
        currentNode = currentNode.getNext();
      }
      newNode.setNext(currentNode);
      newNode.setPrev(currentNode.getPrev());
      currentNode.getPrev().setNext(newNode);
      currentNode.setPrev(newNode);
    }
    size++;
  }

  /**
   * Removes the element at the specified position in this list.
   *
   * @param index the index of the element to be removed
   * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
   */
  public void remove(int index) {
    // If the index is out of bounds, throw an exception
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    // If the size is 1, set the head and tail to null
    if (size == 1) {
      head = null;
      tail = null;
    } else if (index == 0) {
      // If the index is 0, set the head to the next node and set the previous node to null
      head = head.getNext();
      head.setPrev(null);
    } else if (index == size - 1) {
      // If the index is the last node, set the tail to the previous node and set the next node to
      tail = tail.getPrev();
      tail.setNext(null);
    } else {
      // If the index is in the middle, set the previous node's next to the next node and set the
      // next node's previous to the previous node
      Node<T> currentNode = head;
      for (int i = 0; i < index; i++) {
        currentNode = currentNode.getNext();
      }
      currentNode.getPrev().setNext(currentNode.getNext());
      currentNode.getNext().setPrev(currentNode.getPrev());
    }
    size--;
  }

  /**
   * Returns the number of elements in this list.
   *
   * @return the number of elements in this list
   */
  public int size() {
    return size;
  }

  /**
   * Returns true if this list contains no elements.
   *
   * @return true if this list contains no elements
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Returns the index of the first occurrence of the specified element in this list, or -1 if this
   * list does not contain the element.
   *
   * @param data element to search for
   * @return the index of the first occurrence of the specified element in this list, or -1 if this
   *     list does not contain the element
   */
  public int indexOf(T data) {
    Node<T> currentNode = head;
    for (int i = 0; i < size; i++) {
      if (currentNode.getData().equals(data)) {
        return i;
      }
      currentNode = currentNode.getNext();
    }
    return -1;
  }

  /**
   * Returns a string representation of this list. The string representation consists of a list of
   * the list's elements in the order they are returned by its iterator, enclosed in square brackets
   * ("[]"). Adjacent elements are separated by the characters ", " (comma and space).
   *
   * @return a string representation of this list
   */
  @Override
  public String toString() {
    String result = "[";
    Node<T> currentNode = head;
    for (int i = 0; i < size; i++) {
      result += currentNode.getData();
      if (i < size - 1) {
        result += ", ";
      }
      currentNode = currentNode.getNext();
    }
    result += "]";
    return result;
  }
}
