package week5.assignment;

import java.util.ArrayList;
import java.util.HashSet;

public class Student implements Person {

    private String name;
    private HashSet<Course> attendingCourses;
    private HashSet<Course> completedCourses;

    /** A Student is a person that attend Courses and eventually completes them. */
    public Student(String name) {
        this.name = name;
        attendingCourses = new HashSet<>();
        completedCourses = new HashSet<>();
    }

    /** Make this student attend a Course. This will have no effect, if the student has already completed the Course. */
    public void attend(Course co) {
        if (!completedCourses.contains(co) && !attendingCourses.contains(co)) {
            attendingCourses.add(co);
            co.addStudent(this);
        }
    }

    /** Make this Student stop attend a Course. */
    public void stopAttending(Course course) {
        if (attendingCourses.contains(course)) {
            attendingCourses.remove(course);
            course.removeStudent(this);
        }
    }

    /** Added a Course to this Student's set of completed Courses. */
    public void complete(Course course) {
        // If the student was previously attending the course, the course will be removed from the attendingCourses set
        if (attendingCourses.contains(course)) {
            attendingCourses.remove(course);
            course.removeStudent(this);
        }
        completedCourses.add(course);
    }

    /** @return true if this Student attends {@code course}. */
    public boolean doesAttend(Course course) {
        return attendingCourses.contains(course);
    }

    /** @return true if this Student has completed {@code course}. */
    public boolean hasCompleted(Course co) {
        return completedCourses.contains(co);
    }

    /** @return a HashSet of attended Courses. */
    public HashSet<Course> getAttendedCourses() {
        return new HashSet<>(attendingCourses);
    }

    /** @return a HashSet of completed Courses. */
    public HashSet<Course> getCompletedCourses() {
        return new HashSet<>(completedCourses);
    }

    /** @return an ArrayList of all homework this Student needs to do. The homework will be the combined list of
     * homework from all attended Courses. */
    public ArrayList<Homework> getHomeworkList() {
        ArrayList<Homework> homework = new ArrayList<>();
        for (Course attendedCourse : attendingCourses) {
            homework.addAll(attendedCourse.getHomeworkList());
        }
        return homework;
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
