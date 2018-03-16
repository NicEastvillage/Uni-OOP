package week5.personproblem;

import java.util.Objects;

public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void incrementAge() {
        age++;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", " + age;
    }

    @Override
    public int compareTo(Person that) {
        int firstNameCmp = firstName.compareTo(that.firstName);
        if (firstNameCmp != 0) {
            return firstNameCmp;
        }
        int lastNameCmp = lastName.compareTo(that.lastName);
        if (lastNameCmp != 0) {
            return lastNameCmp;
        }
        return age - that.age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, lastName, age);
    }
}
