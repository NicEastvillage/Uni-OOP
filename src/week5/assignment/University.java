package week5.assignment;

import java.util.HashSet;
import java.util.Set;

public class University {

    private final String name;
    private HashSet<Course> courses;
    private HashSet<Professor> professors;
    private HashSet<Student> students;

    public University(String name) {
        this.name = name;
        courses = new HashSet<>();
        professors = new HashSet<>();
        students = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void addCourse(Course co) {
        courses.add(co);
    }

    public void removeCourse(Course co) {
        if (courses.remove(co)) {
            co.setProfessor(null, null);
            co.getAttendingStudents().forEach(co::removeStudent);
        }
    }

    public void registerStudent(Student student) {
        students.add(student);
    }

    public void unregisterStudent(Student student) {
        if (students.remove(student)) {
            student.getAttendedCourses().forEach(student::stopAttending);
        }
    }

    public boolean isStudentRegistered(Student student) {
        return students.contains(student);
    }

    public HashSet<Student> getStudents() {
        return new HashSet<>(students);
    }

    public void registerProfessor(Professor professor) {
        professors.add(professor);
    }

    public void unregisterProfessor(Professor professor) {
        if (professors.remove(professor)) {
            professor.getCoursesLectured().forEach(c -> c.setProfessor(null, null));
        }
    }

    public boolean isProfessorRegistered(Professor professor) {
        return professors.contains(professor);
    }

    public HashSet<Professor> getProfessors() {
        return new HashSet<>(professors);
    }
}
