package week5.personproblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class PersonMain {
    public static void main(String[] args) {
        HashSet<Person> set = new HashSet<>();
        set.add(new Person("John", "Fitler", 23));
        set.add(new Person("Sandra", "Karlson", 29));
        set.add(new Person("John", "Fitler", 23));
        set.add(new Person("Julian", "Fitler", 30));
        set.add(new Person("John", "Fitler", 23));

        System.out.println(">> HashSet contains:");
        for (Person person : set) {
            System.out.println(person);
        }

        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("John", "Fitler", 23));
        list.add(new Person("Sandra", "Karlson", 29));
        list.add(new Person("John", "Karlson", 40));
        list.add(new Person("Julian", "Fitler", 30));
        list.add(new Person("Drake", "Jr.", 11));

        Collections.sort(list);
        System.out.println(">> Sorted ArrayList contains:");
        for (Person person : list) {
            System.out.println(person);
        }

        Collections.sort(list, (per1, per2) -> {
            int ageCmp = per1.getAge() - per2.getAge();
            if (ageCmp != 0) {
                return ageCmp;
            }
            int lastNameCmp = per1.getLastName().compareTo(per2.getLastName());
            if (lastNameCmp != 0) {
                return lastNameCmp;
            }
            return per1.getFirstName().compareTo(per2.getLastName());
        });
        System.out.println(">> Inv-sorted ArrayList contains:");
        for (Person person : list) {
            System.out.println(person);
        }
    }
}
