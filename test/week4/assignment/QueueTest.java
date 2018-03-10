package week4.assignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    public void queue01() {
        Queue<String> strQueue = new Queue<>();
        strQueue.enqueue("Hello");
        strQueue.enqueue("World");
        strQueue.enqueue("Foo");
        assertEquals("Hello", strQueue.dequeue());
        assertEquals("World", strQueue.dequeue());
        assertEquals("Foo", strQueue.dequeue());
    }

    @Test
    public void queue02() {
        Queue<Integer> intQueue = new Queue<>();
        intQueue.enqueue(1);
        intQueue.enqueue(2);
        intQueue.enqueue(3);
        assertEquals(Integer.valueOf(1), intQueue.dequeue());
        assertEquals(Integer.valueOf(2), intQueue.dequeue());
        assertEquals(Integer.valueOf(3), intQueue.dequeue());
    }

    @Test
    public void peek01() {
        Queue<Integer> intQueue = new Queue<>();
        intQueue.enqueue(1);
        intQueue.enqueue(2);
        intQueue.enqueue(3);
        assertEquals(Integer.valueOf(1), intQueue.peek());
        assertEquals(Integer.valueOf(1), intQueue.peek());
    }

    @Test
    public void peek02() {
        Queue<Integer> intQueue = new Queue<>();
        assertEquals(null, intQueue.peek());
    }

    @Test
    public void dequeue01() {
        Queue<Integer> intQueue = new Queue<>();
        RuntimeException e = assertThrows(RuntimeException.class, intQueue::dequeue);
        assertNotNull(e);
    }

    @Test
    public void getLength01() {
        Queue<Integer> intQueue = new Queue<>();
        intQueue.enqueue(1);
        intQueue.enqueue(2);
        intQueue.enqueue(3);
        intQueue.enqueue(4);
        assertEquals(4, intQueue.getLength());
    }

    @Test
    public void getLength02() {
        Queue<Integer> intQueue = new Queue<>();
        assertEquals(0, intQueue.getLength());
    }

    @Test
    public void drain01() {
        Queue<Integer> intQueue = new Queue<>();
        intQueue.enqueue(1);
        intQueue.enqueue(2);
        intQueue.enqueue(3);
        intQueue.enqueue(4);
        assertEquals(Integer.valueOf(2), intQueue.drain(2));
    }

    @Test
    public void drain02() {
        Queue<Integer> intQueue = new Queue<>();
        assertEquals(null, intQueue.drain(3));
    }

    @Test
    public void drain03() {
        Queue<Integer> intQueue = new Queue<>();
        intQueue.enqueue(1);
        intQueue.enqueue(2);
        intQueue.enqueue(3);
        intQueue.enqueue(4);
        intQueue.drain(3);
        assertEquals(1, intQueue.getLength());
    }
}