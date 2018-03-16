package week5.problem6;

import java.util.ArrayList;
import java.util.List;

public class DoubleUpListMain {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("C");

        list = doubleUpList(list);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public static <T> List<T> doubleUpList(List<T> list) {
        List<T> newList = new ArrayList<>();
        for (T t : list) {
            newList.add(t);
            newList.add(t);
        }
        return newList;
    }
}
