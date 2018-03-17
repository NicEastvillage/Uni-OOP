package week5.problem14;

import java.util.HashMap;
import java.util.Map;

public class MultiSet<E> {

    private Map<E, Integer> map;

    public MultiSet() {
        map = new HashMap<>();
    }

    public int countAll() {
        return map.values().stream().mapToInt(x -> x).sum();
    }

    public int count(E e) {
        if (map.containsKey(e)) {
            return map.get(e);
        }
        return 0;
    }

    public void add(E e) {
        if (!map.containsKey(e)) {
            map.put(e, 0);
        }
        map.put(e, map.get(e) + 1);
    }

    public void remove(E e) {
        if (map.containsKey(e)) {
            map.put(e, Math.max(map.get(e) - 1, 0));
        }
    }

    public int size() {
        return (int) map.values().stream().filter(x -> x > 0).count();
    }
}
