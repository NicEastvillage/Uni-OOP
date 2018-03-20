package week5.assignment;

public class Course {

    private Professor lecturer;
    private final String name;
    private final String shortName;

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
}
