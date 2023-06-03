package nz.ac.auckland.se281.datastructures;

public class Stack <T> {
    Node<T> top;
    int stackSize;

    public Stack() {
        // Creates a new stack.
        top = null;
        this.stackSize = 0;
    }

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

    public T pop() {
        //Removes the node at the top of the stack.
        Node<T> temp = top;
        top = top.getNext();
        stackSize--;
        return temp.getData();
    }

    public T peek() {
        // Returns the value of the node at the top of the stack
        return top.getData();
    }
    
    public int size() {
        // Returns the number of nodes in the stack.
        return stackSize;
    }

    public boolean isEmpty() {
        return stackSize == 0;
    }

    @Override
    public String toString() {
        // Returns a string representation of the stack e.g. [1, 2, 3, 4]
        String result = "[";
        Node<T> current = top;
        for (int i = 0; i < stackSize; i++) {
            result += current.toString();
            if (i < stackSize -1) {
                result += ", ";
            }
            current = current.getNext();
        }
        result += "]";
        return result;
    }
}
