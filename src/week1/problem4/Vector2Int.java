package week1.problem4;

public class Vector2Int {

    private int x, y;

    public Vector2Int(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Vector2Int add(Vector2Int first, Vector2Int second) {
        return new Vector2Int(first.x + second.x, first.y + second.y);
    }

    public static Vector2Int subtract(Vector2Int first, Vector2Int second) {
        return new Vector2Int(first.x - second.x, first.y - second.y);
    }

    public static int scalar(Vector2Int first, Vector2Int second) {
        return first.x * second.x + first.y * second.y;
    }

    /*
    public static int cross(Vector2Int first, Vector2Int second) {
        return 0;
    }*/

    public static boolean equals(Vector2Int first, Vector2Int second) {
        return first.x == second.x && first.y == second.y;
    }
}
