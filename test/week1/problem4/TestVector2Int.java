package week1.problem4;

import org.junit.jupiter.api.Test;
import week1.problem4.Vector2Int;

import static org.junit.jupiter.api.Assertions.*;

class TestVector2Int {

    @Test
    void add01() {
        Vector2Int result = Vector2Int.add(new Vector2Int(1, 2), new Vector2Int(5, 5));
        assertTrue(Vector2Int.equals(result, new Vector2Int(6, 7)));
    }

    @Test
    void add02() {
        Vector2Int result = Vector2Int.add(new Vector2Int(4, -1), new Vector2Int(-4, 100));
        assertTrue(Vector2Int.equals(result, new Vector2Int(0, 99)));
    }

    @Test
    void subtract01() {
        Vector2Int result = Vector2Int.subtract(new Vector2Int(3, 8), new Vector2Int(4, 5));
        assertTrue(Vector2Int.equals(result, new Vector2Int(-1, 3)));
    }

    @Test
    void subtract02() {
        Vector2Int result = Vector2Int.subtract(new Vector2Int(40, 0), new Vector2Int(55, 150));
        assertTrue(Vector2Int.equals(result, new Vector2Int(-15, -150)));
    }

    @Test
    void scalar01() {
        int result = Vector2Int.scalar(new Vector2Int(4, 2), new Vector2Int(1, 2));
        assertEquals(result, 4*1 + 2*2);
    }

    @Test
    void scalar02() {
        int result = Vector2Int.scalar(new Vector2Int(7, -2), new Vector2Int(10, 13));
        assertEquals(result, 7*10 + -2*13);
    }
}