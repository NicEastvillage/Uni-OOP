package week4.assignment;

import java.util.function.Predicate;

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
        end = -1;
        elements = 0;
    }

    /** Removes all elements from the Queue. */
    public void clear() {
        arr = (T[]) new Object[DEFAULT_SIZE];
        start = 0;
        end = -1;
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
    }

    /** Remove and return the next element in the queue.
     * @return the next element in the queue. */
    public T dequeue() throws RuntimeException {

        // Empty?
        if (elements == 0) {
            throw new RuntimeException("Queue is empty.");
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
        end = elements - 1;

        arr = newArr;
    }

    /** Removes {@code count} elements from the queue and returns the last removed element. If {@code count} is greater
     * than the amount of elements in the Queue, all elements will be removed and the last removed element will be returned.
     * @param count the amount of removed elements, or null if queue is empty.
     * @return the last removed element */
    public T drain(int count) {

        T last = null;

        int elementsToRemove = Math.min(elements, count);
        for (int i = 0; i < elementsToRemove; i++) {
            last = dequeue();
        }

        return last;
    }

    /** Repeatedly removes elements from the queue as long as the predicate is true. Stops when the predicate returns
     * false. For example, {@code drainWhile(x -> true)} will completely drain the queue. */
    public void drainWhile(Predicate<T> pred) {
        while (elements > 0) {
            T next = peek();
            if (pred.test(next)) {
                dequeue();
            } else {
                break;
            }
        }
    }

    /** @return the number of elements in the Queue. */
    public int getLength() {
        return elements;
    }
}
