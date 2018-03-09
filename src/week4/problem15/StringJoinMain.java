package week4.problem15;

import java.util.Random;

public class StringJoinMain {
    public static void main(String[] args) {

        System.out.println(joinAll(new String[] {"a", "b", "c", "d"}, (x, y) -> x + y));
        System.out.println(joinAll(new String[] {"a", "b", "c", "d"}, (x, y) -> x + "." + y));
        System.out.println(joinAll(new String[] {"a", "b", "c", "d"}, (x, y) -> x));
        System.out.println(joinAll(new String[] {"a", "b", "c", "d"}, (x, y) -> new Random().nextBoolean() ? x + y : y + x));
    }

    public static String joinAll(String[] strs, Joinable joinFunction) {
        if (strs.length == 0) return "";
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            res = joinFunction.join(res, strs[i]);
        }
        return res;
    }
}
