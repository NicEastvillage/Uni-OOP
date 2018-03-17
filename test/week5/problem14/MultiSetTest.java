package week5.problem14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiSetTest {

    @Test
    public void multiset01() {
        MultiSet<String> set = new MultiSet<>();
        set.add("Hello");
        set.add("Hello");
        set.add("World");

        assertEquals(2, set.count("Hello"));
        assertEquals(1, set.count("World"));
        assertEquals(0, set.count("Bye"));
    }

    @Test
    public void countAll01() {
        MultiSet<String> set = new MultiSet<>();
        set.add("Hello");
        set.add("Hello");
        set.add("World");

        assertEquals(3, set.countAll());
    }

    @Test
    public void addRemove01() {
        MultiSet<String> set = new MultiSet<>();
        set.add("Hello");
        set.add("Hello");
        set.add("World");
        set.remove("World");
        set.remove("Bye");

        assertEquals(2, set.count("Hello"));
        assertEquals(0, set.count("World"));
        assertEquals(0, set.count("Bye"));
    }

    @Test
    public void size01() {
        MultiSet<String> set = new MultiSet<>();
        set.add("Hello");
        set.add("Hello");
        set.add("World");
        set.remove("World");
        set.remove("Bye");

        assertEquals(1, set.size(), "There's should only one element of type \"Hello\"");
    }
}