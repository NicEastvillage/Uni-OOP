package week5.problem13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ThousandStreamMain {
    public static void main(String[] args) {
        /* Write a method that constructs a list of integers from zero to a thousand.
            Use streams to (a) filter all even numbers, (b) multiply all numbers by three, (c) select
            the first eleven elements, and (d) compute their sum.*/

        int sum = IntStream.range(0, 1001)
                .filter(x -> x % 2 == 0)
                .limit(11)
                .map(x -> x * 3)
                .sum();

        System.out.println(sum); // should print 330
    }
}
