package week5.assignment;

import java.util.HashSet;
import java.util.function.Consumer;

public class Course {

    private Professor professor;
    private final String name;
    private final String shortName;
    private HashSet<Student> attendingStudents;
    private Consumer<Course> professorChangeCallback;
    private boolean paused;

    /** A Course */
    public Course(Professor professor, String name, String shortName) {
        this.professor = professor;
        this.name = name;
        this.shortName = shortName;
        attendingStudents = new HashSet<>();
        paused = professor == null;
    }

    /** Make a Student attend this Course. */
    public void addStudent(Student student) {
        attendingStudents.add(student);
        student.attend(this);
    }

    /** Make a Student stop attending this Course. */
    public void removeStudent(Student st) {
        attendingStudents.remove(st);
        st.stopAttending(this);
    }

    /** @return true if {@code student} attends this Course. */
    public boolean doesStudentAttend(Student student) {
        return attendingStudents.contains(student);
    }

    /** Set the Professor that lectures this Course replacing the previous lecturer. If set to null the Course will
     * be marked as paused and can only resumed when a new non-Professor is set as lecturer.
     * @param professorChangeCallback a callback with this Course as the parameter. Called once when this method is
     *                                called again. Can be used to notify the previous lecturer, that he or she
     *                                is no longer the lecturer of this Course. Can be null. */
    public void setProfessor(Professor professor, Consumer<Course> professorChangeCallback) {
        if (professorChangeCallback != null) {
            this.professorChangeCallback.accept(this);
        } else if (professor == null) {
            // Pause the course if it has no lecturer
            pause();
        } else {
            professor.lectureCourse(this);
        }

        this.professor = professor;
        this.professorChangeCallback = professorChangeCallback;
    }

    /** @return the Professor that lectures this Course. */
    public Professor getProfessor() {
        return professor;
    }

    /** The name of this Course. */
    public String getName() {
        return name;
    }

    /** The short name of this Course, e.g. CS is short for Computer Science. */
    public String getShortName() {
        return shortName;
    }

    /** @return a HashSet of Students attending this Course. */
    public HashSet<Student> getAttendingStudents() {
        return new HashSet<>(attendingStudents);
    }

    /** Pause this Course. Can be resumed with {@code start()}. */
    public void pause() {
        paused = true;
    }

    /** @return true if this Course is paused. */
    public boolean isPaused() {
        return paused;
    }

    /** @return true if this Course can be started/resumed or if it isn't paused. A Course must have a lecturer to start. */
    public boolean canStart() {
        return !paused || professor != null;
    }

    /** Start a paused Course. A Course must have a lecturer to start.
     * @return true if this Course can be started/resumed or if it isn't paused. */
    public boolean start() {
        if (canStart()) {
            paused = false;
            return true;
        }
        return false;
    }
}
