package week4.assignment;

/** A Queue is a First-in-first-out collection. */
public class Queue<T> {

    private static final int DEFAULT_SIZE = 16;

    private T[] arr;
    /** The index of the start of the queue The oldest */
    private int start;
    /** The index of the end of the queue. The newest */
    private int end;
    /** Number of elements currently in the queue */
    private int elements;

    /** A Queue is a First-in-first-out collection. */
    public Queue() {
        arr = (T[]) new Object[DEFAULT_SIZE];
        start = 0;
        end = 0;
        elements = 0;
    }

    /** Enqueue an element. */
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

    /** Remove and return the next element in the queue.
     * @return the next element in the queue. */
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

    /** @return the next element in the queue without removing it from the queue. */
    public T peek() {
        if (elements == 0) {
            return null; // Technically redundant
        }

        return arr[start];
    }

    /** Move all elements in the internal array to a new array twice as big */
    private void expand() {

        T[] newArr = (T[]) new Object[elements * 2];

        // Move elements to new array
        for (int i = 0; i < elements; i++) {
            int fromIndex = (i + start) % arr.length;
            newArr[i] = arr[fromIndex];
        }

        // Update indices
        start = 0;
        end = elements;

        arr = newArr;
    }
}
