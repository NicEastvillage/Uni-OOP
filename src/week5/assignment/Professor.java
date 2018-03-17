package week5.assignment;

import java.util.HashSet;
import java.util.Set;

public class Professor extends Person {

    private HashSet<Course> coursesLectured;

    public Professor(String name) {
        super(name);
        coursesLectured = new HashSet<>();
    }

    public boolean doesLecture(Course co) {
        return coursesLectured.contains(co);
    }

    public void lectureCourse(Course co) {
        coursesLectured.add(co);
        co.setProfessor(this, this::stopLectureCourse);
    }

    private void stopLectureCourse(Course co) {
        coursesLectured.remove(co);
    }

    public HashSet<Course> getCoursesLectured() {
        return new HashSet<>(coursesLectured);
    }
}
