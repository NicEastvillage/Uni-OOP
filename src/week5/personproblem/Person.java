package week5.personproblem;

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
}
