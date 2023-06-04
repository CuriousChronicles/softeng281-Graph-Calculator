package nz.ac.auckland.se281.datastructures;

public class Queue<T> {
  private LinkedList<T> queue;

  public Queue() {
    // Create a new queue
    this.queue = new LinkedList<>();
  }

  public void enqueue(T data) {
    // Adds an element to the back of the queue
    queue.add(data);
  }

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

  public T peek() {
    // Returns the element at the front of the queue without removing it
    return queue.get(0);
  }

  public boolean isEmpty() {
    // Returns true if the queue is empty, false otherwise
    return queue.size() == 0;
  }

  @Override
  public String toString() {
    // Returns a string representation of the queue e.g. [1, 2, 3, 4]
    return queue.toString();
  }
}
