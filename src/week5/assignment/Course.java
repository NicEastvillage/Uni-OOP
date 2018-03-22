package week5.assignment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.function.Consumer;

public class Course {

    private Professor professor;
    private final String name;
    private final String shortName;
    private HashSet<Student> attendingStudents;
    private Consumer<Course> professorChangeCallback;
    private ArrayList<Homework> homeworkList;
    private boolean paused;

    /** A Course */
    public Course(Professor professor, String name, String shortName) {
        this.professor = professor;
        this.name = name;
        this.shortName = shortName;
        attendingStudents = new HashSet<>();
        homeworkList = new ArrayList<>();
        paused = professor == null;
    }

    /** Make a Student attend this Course. */
    public void addStudent(Student student) {
        if (!attendingStudents.contains(student)) {
            attendingStudents.add(student);
            student.attend(this);
        }
    }

    /** Make a Student stop attending this Course. */
    public void removeStudent(Student student) {
        if (attendingStudents.contains(student)) {
            attendingStudents.remove(student);
            student.stopAttending(this);
        }
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

    /** Add a piece of Homework for this Course. Homework cannot be null. */
    public void addHomework(Homework homework) throws NullPointerException {
        if (homework == null) throw new NullPointerException("Homework was null");
        homeworkList.add(homework);
    }

    /** Remove a piece of Homework.
     * @return true, if the homework was removed. */
    public boolean removeHomework(Homework homework) {
        if (homeworkList.contains(homework)) {
            homeworkList.remove(homework);
            return true;
        }
        return false;
    }

    /** @return an ArrayList of all Homework for this Course. */
    public ArrayList<Homework> getHomeworkList() {
        return new ArrayList<>(homeworkList);
    }

    /** @return the {@code <courseName> (<shortName>)}.*/
    @Override
    public String toString() {
        return String.format("%s (%s)", name, shortName);
    }
}
