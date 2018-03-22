package week5.assignment;

import java.util.HashSet;

public class University {

    private final String name;
    private HashSet<Course> courses;
    private HashSet<Professor> professors;
    private HashSet<Student> students;

    /** A University helps organizing Students, Professors and Courses. */
    public University(String name) {
        this.name = name;
        courses = new HashSet<>();
        professors = new HashSet<>();
        students = new HashSet<>();
    }

    /** @return the name of the University. */
    public String getName() {
        return name;
    }

    /** Add a Course at University. */
    public void addCourse(Course co) {
        courses.add(co);
    }

    /** Remove a Course at the University. */
    public void removeCourse(Course co) {
        if (courses.remove(co)) {
            co.setProfessor(null, null);
            co.getAttendingStudents().forEach(co::removeStudent);
        }
    }

    /** @return a HashSet of all Courses at the University. */
    public HashSet<Course> getCourses() {
        return new HashSet<>(courses);
    }

    /** Register a Student at University.*/
    public void registerStudent(Student student) {
        students.add(student);
    }

    /** Unregister a Student at the University. This will make them stop attending any Courses. */
    public void unregisterStudent(Student student) {
        if (students.remove(student)) {
            student.getAttendedCourses().forEach(student::stopAttending);
        }
    }

    /** @return true, if the Student is registered at the University. */
    public boolean isStudentRegistered(Student student) {
        return students.contains(student);
    }

    /** @return a HashSet of all Students registered at the University. */
    public HashSet<Student> getStudents() {
        return new HashSet<>(students);
    }

    /** Register a Professor at University. */
    public void registerProfessor(Professor professor) {
        professors.add(professor);
    }

    /** Unregister a Student at the University. Any Course lecturer by this Professor will be paused until
     * a new lecturer for the Course is set. */
    public void unregisterProfessor(Professor professor) {
        if (professors.remove(professor)) {
            professor.getCoursesLectured().forEach(c -> c.setProfessor(null, null));
        }
    }

    /** @return true, if the Professor is registered at the University. */
    public boolean isProfessorRegistered(Professor professor) {
        return professors.contains(professor);
    }

    /** @return a HashSet of all Professors registered at the University. */
    public HashSet<Professor> getProfessors() {
        return new HashSet<>(professors);
    }

    @Override
    public String toString() {
        return getName();
    }
}
