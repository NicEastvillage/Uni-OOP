package week5.assignment;

import java.util.HashSet;

public class Professor implements Person {

    private String name;
    private HashSet<Course> coursesLectured;

    /** A professor is a person that lectures courses at a university */
    public Professor(String name) {
        this.name = name;
        coursesLectured = new HashSet<>();
    }

    /** @returm true if this Professor lectures {@code course}*/
    public boolean doesLecture(Course course) {
        return coursesLectured.contains(course);
    }

    /** Set this Professor as the lecturer of a Course, replacing previous lecturer. */
    public void lectureCourse(Course co) {
        coursesLectured.add(co);
        co.setProfessor(this, this::stopLectureCourse);
    }

    /** Make this Professor stop lecturing a Course. This will pause the Course.
     * @return true if the Professor was the lecturer of {@code course}. */
    private boolean stopLectureCourse(Course course) {
        if (coursesLectured.contains(course)) {
            coursesLectured.remove(course);
            course.setProfessor(null, null);
        }
        return false;
    }

    /** @return a HashSet of Courses this Professor lectures. */
    public HashSet<Course> getCoursesLectured() {
        return new HashSet<>(coursesLectured);
    }

    /** @return the name of this Professor. */
    @Override
    public String getName() {
        return name;
    }

    /** @return {@code "Prof. <name>"}*/
    public String getNameWithPrefix() {
        return "Prof. " + name;
    }

    @Override
    public String toString() {
        return getNameWithPrefix();
    }
}
