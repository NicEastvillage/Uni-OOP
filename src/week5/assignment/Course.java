package week5.assignment;

import java.util.Objects;

public class Course {

    private final String name;
    private final String shortName;
    private Professor lecturer;

    /** A Course */
    public Course(Professor lecturer, String name, String shortName) {
        this.lecturer = lecturer;
        this.name = name;
        this.shortName = shortName;
    }

    /** @return the Professor that lectures this Course. */
    public Professor getLecturer() {
        return lecturer;
    }

    /** The name of this Course. */
    public String getName() {
        return name;
    }

    /** The short name of this Course, e.g. CS is short for Computer Science. */
    public String getShortName() {
        return shortName;
    }

    /** @return the {@code <courseName> (<shortName>)}.*/
    @Override
    public String toString() {
        return String.format("%s (%s)", name, shortName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(name, course.name) &&
                Objects.equals(shortName, course.shortName) &&
                Objects.equals(lecturer, course.lecturer);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, shortName, lecturer);
    }
}
