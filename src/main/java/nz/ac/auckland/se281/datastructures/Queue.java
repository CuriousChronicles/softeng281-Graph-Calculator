package nz.ac.auckland.se281.datastructures;

/**
 * This class represents a queue data structure of generic type T.
 *
 * @param <T> The type of elements held in this collection.
 */
public class Queue<T> {
  private LinkedList<T> queue;

  /** Constructs an empty queue. */
  public Queue() {
    // Create a new queue
    this.queue = new LinkedList<>();
  }

  /**
   * Inserts the specified element into the back of this queue.
   *
   * @param data the element to add
   */
  public void enqueue(T data) {
    // Adds an element to the back of the queue
    queue.add(data);
  }

  /**
   * Retrieves and removes the head of this queue. This method throws an exception if this queue is
   * empty.
   *
   * @return the head of this queue
   */
  public T dequeue() {
    // Removes the element from the front of the queue
    if (queue.size() != 0) {
      T data = queue.get(0);
      queue.remove(0);
      return data;
    } else {
      System.out.println("Queue is empty");
      return null;
    }
  }

  /**
   * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
   *
   * @return the head of this queue, or null if this queue is empty
   */
  public T peek() {
    // Returns the element at the front of the queue without removing it
    return queue.get(0);
  }

  /**
   * Returns true if this queue contains no elements.
   *
   * @return true if this queue contains no elements
   */
  public boolean isEmpty() {
    // Returns true if the queue is empty, false otherwise
    return queue.size() == 0;
  }

  /**
   * Returns a string representation of this queue.
   *
   * @return a string representation of this queue
   */
  @Override
  public String toString() {
    // Returns a string representation of the queue e.g. [1, 2, 3, 4]
    return queue.toString();
  }
}
