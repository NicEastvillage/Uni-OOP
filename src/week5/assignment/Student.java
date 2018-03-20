package week5.assignment;

import java.util.Objects;

public class Student implements Person {

    private String name;

    /** A Student is a person that attend Courses and eventually completes them. */
    public Student(String name) {
        this.name = name;
    }

    /** @return the name of this Student. */
    @Override
    public String getName() {
        return name;
    }

    /** @return the name of this Student. */
    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
