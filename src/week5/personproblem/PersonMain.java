package week5.personproblem;

import java.util.HashSet;

public class PersonMain {
    public static void main(String[] args) {
        HashSet<Person> set = new HashSet<>();
        set.add(new Person("John", "Fitler", 23));
        set.add(new Person("Sandra", "Karlson", 29));
        set.add(new Person("John", "Fitler", 23));
        set.add(new Person("Julian", "Fitler", 30));
        set.add(new Person("John", "Fitler", 23));

        for (Person person : set) {
            System.out.println(person);
        }
    }
}
