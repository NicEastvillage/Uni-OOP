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
    public void expand01() {
        Queue<Integer> intQueue = new Queue<>();
        for (int i = 0; i < 200; i++) {
            intQueue.enqueue(i);
        }
        for (int i = 0; i < 200; i++) {
            assertEquals(Integer.valueOf(i), intQueue.dequeue());
        }
    }

    @Test
    public void expand02() {
        Queue<Integer> intQueue = new Queue<>();
        // Enqueue 0-49
        for (int i = 0; i < 50; i++) {
            intQueue.enqueue(i);
        }
        // Dequeue 0-24
        for (int i = 0; i < 25; i++) {
            assertEquals(Integer.valueOf(i), intQueue.dequeue());
        }
        // Enqueue 50-149
        for (int i = 50; i < 150; i++) {
            intQueue.enqueue(i);
        }
        // Dequeue 25-49
        for (int i = 25; i < 50; i++) {
            assertEquals(Integer.valueOf(i), intQueue.dequeue());
        }
    }

    @Test
    public void peek01() {
        Queue<Integer> intQueue = new Queue<>();
        intQueue.enqueue(1);
        intQueue.enqueue(2);
        intQueue.enqueue(3);
        assertEquals(Integer.valueOf(1), intQueue.peek());
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

    @Test
    public void drainWhile01() {
        Queue<Integer> intQueue = new Queue<>();
        intQueue.enqueue(1);
        intQueue.enqueue(2);
        intQueue.enqueue(3);
        intQueue.enqueue(4);
        intQueue.drainWhile(x -> x < 3);
        assertEquals(2, intQueue.getLength());
    }

    @Test
    public void drainWhile02() {
        Queue<Integer> intQueue = new Queue<>();
        intQueue.enqueue(1);
        intQueue.enqueue(2);
        intQueue.enqueue(3);
        intQueue.enqueue(4);
        intQueue.drainWhile(x -> true);
        assertEquals(0, intQueue.getLength());
    }

    @Test
    public void drainWhile03() {
        Queue<Integer> intQueue = new Queue<>();
        intQueue.enqueue(1);
        intQueue.enqueue(2);
        intQueue.enqueue(3);
        intQueue.enqueue(4);
        intQueue.drainWhile(x -> false);
        assertEquals(4, intQueue.getLength());
    }

    @Test
    public void clear01() {
        Queue<Integer> intQueue = new Queue<>();
        intQueue.enqueue(1);
        intQueue.enqueue(2);
        intQueue.enqueue(3);
        intQueue.enqueue(4);
        intQueue.clear();
        assertEquals(0, intQueue.getLength());
    }
}