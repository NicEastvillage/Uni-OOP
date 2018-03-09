package week4.assignment;

import java.rmi.server.ExportException;

public class Queue<T> {

    private static final int DEFAULT_SIZE = 16;

    private T[] arr;
    /** The index of the start of the queue The oldest */
    private int start;
    /** The index of the end of the queue. The newest */
    private int end;
    /** Number of elements currently in the queue */
    private int elements;

    public Queue() {
        arr = (T[]) new Object[DEFAULT_SIZE];
        start = 0;
        end = 0;
        elements = 0;
    }

    public void enqueue(T element) {

        // Overflow
        if (elements == arr.length) {
            expand();
        }

        end = (end + 1) % arr.length;

        // Insert
        arr[end] = element;
        elements++;

        // Overflow?
        if (end == start) {
            expand();
        }
    }

    public T dequeue() throws Exception {

        // Empty?
        if (elements == 0) {
            throw new Exception("Queue is empty.");
        }

        // Get element
        T element = arr[start];
        arr[start] = null;
        elements--;

        start = (start + 1) % arr.length;

        return element;
    }

    private void expand() {

    }
}
