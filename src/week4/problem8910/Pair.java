package week4.problem8910;

public class Pair<A, B> {
    private A first;
    private B second;

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    public Pair<B, A> swap() {
        return new Pair<>(second, first);
    }

    public <C> Pair<C, B> setFirst(C newFirst) {
        return new Pair<>(newFirst, second);
    }

    public <C> Pair<A, C> setSecond(C newSecond) {
        return new Pair<>(first, newSecond);
    }

    @Override
    public String toString() {
        return "(" + first.toString() + ", " + second.toString() + ")";
    }
}
