package week4.problem8910;

public class PairMain {
    public static void main(String[] args) {
        Pair<Integer, String> pair = new Pair<>(42, "Giraffe");
        System.out.println(pair.toString());

        Pair<String, Integer> swapped = pair.swap();
        System.out.println(swapped.toString());

        Pair<Boolean, String> withBoolean = pair.setFirst(false);
        System.out.println(withBoolean);

        Pair<String, Double> withDouble = swapped.setSecond(3.14);
        System.out.println(withDouble.toString());

    }
}
