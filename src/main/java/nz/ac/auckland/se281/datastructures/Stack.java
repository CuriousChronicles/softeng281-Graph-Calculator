package nz.ac.auckland.se281.datastructures;

/**
 * This class represents a stack data structure of generic type T.
 *
 * @param <T> The type of elements held in this collection.
 */
public class Stack<T> {
  private Node<T> top;
  private int stackSize;

  /** Constructs an empty stack. */
  public Stack() {
    // Creates a new stack.
    top = null;
    this.stackSize = 0;
  }

  /**
   * Pushes an item onto the top of this stack.
   *
   * @param data the item to be pushed onto this stack
   */
  public void push(T data) {
    // Adds a new node to the top of the stack.
    if (stackSize == 0) {
      top = new Node<T>(data);
      stackSize++;
    } else {
      Node<T> newNode = new Node<T>(data);
      newNode.setNext(top);
      top = newNode;
      stackSize++;
    }
  }

  /**
   * Removes the object at the top of this stack and returns that object as the value of this
   * function.
   *
   * @return The object at the top of this stack
   */
  public T pop() {
    // Removes the node at the top of the stack.
    Node<T> temp = top;
    top = top.getNext();
    stackSize--;
    return temp.getData();
  }

  /**
   * Looks at the object at the top of this stack without removing it from the stack.
   *
   * @return the object at the top of this stack
   */
  public T peek() {
    // Returns the value of the node at the top of the stack
    return top.getData();
  }

  /**
   * Tests if this stack is empty.
   *
   * @return true if and only if this stack contains no items; false otherwise
   */
  public int size() {
    // Returns the number of nodes in the stack.
    return stackSize;
  }

  /**
   * Returns true is the stack is empty.
   *
   * @return true if and only if this stack contains no items; false otherwise
   */
  public boolean isEmpty() {
    return stackSize == 0;
  }

  /**
   * Returns a string representation of this stack.
   *
   * @return a string representation of this stack
   */
  @Override
  public String toString() {
    StringBuilder result = new StringBuilder("[");
    Node<T> currentNode = top;
    for (int i = 0; i < stackSize; i++) {
      result.append(currentNode.getData());
      if (i < stackSize - 1) {
        result.append(", ");
      }
      currentNode = currentNode.getNext();
    }
    result.append("]");
    return result.toString();
  }
}
