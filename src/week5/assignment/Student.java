package week5.assignment;

import java.util.HashSet;
import java.util.Set;

public class Student extends Person {

    private HashSet<Course> attendingCourses;
    private HashSet<Course> completedCourses;

    public Student(String name) {
        super(name);
        attendingCourses = new HashSet<>();
        completedCourses = new HashSet<>();
    }

    public void attend(Course co) {
        if (!completedCourses.contains(co)) {
            attendingCourses.add(co);
            co.addStudent(this);
        }
    }

    public void stopAttending(Course co) {
        attendingCourses.remove(co);
        co.removeStudent(this);
    }

    public void complete(Course co) {
        if (attendingCourses.contains(co)) {
            attendingCourses.remove(co);
            co.removeStudent(this);
        }
        completedCourses.add(co);
    }

    public boolean doesAttend(Course co) {
        return attendingCourses.contains(co);
    }

    public boolean hasCompleted(Course co) {
        return completedCourses.contains(co);
    }

    public HashSet<Course> getAttendedCourses() {
        return new HashSet<>(attendingCourses);
    }

    public HashSet<Course> getCompletedCourses() {
        return new HashSet<>(completedCourses);
    }
}
