package nz.ac.auckland.se281.datastructures;

public class LinkedList<T> {
  private int size;
  private Node<T> head;
  private Node<T> tail;

  public LinkedList() {
    this.size = 0;
    this.head = null;
    this.tail = null;
  }

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

  public void insert(int index, T data) {
    // Inserts a node at a specific index
    // Go through the Linked list until you reach the index
    // Create a new node with the data
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    if (index == 0) {
      Node<T> newNode = new Node<>(data);
      head.setNext(newNode);
      newNode.setPrev(head);
      head = newNode;
    } else if (index == size) {
      Node<T> newNode = new Node<>(data);
      tail.setNext(newNode);
      newNode.setPrev(tail);
      tail = newNode;
    } else {
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

  public void remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    if (size == 1) {
        head = null;
        tail = null;
    } else if (index == 0) {
        head = head.getNext();
        head.setPrev(null);
    } else if (index == size - 1) {
        tail = tail.getPrev();
        tail.setNext(null);
    } else {
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        currentNode.getPrev().setNext(currentNode.getNext());
        currentNode.getNext().setPrev(currentNode.getPrev());
    }
    size--;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

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
