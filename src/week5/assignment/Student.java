package week5.assignment;

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
}
