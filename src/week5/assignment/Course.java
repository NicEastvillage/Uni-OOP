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

    public Course(Professor professor, String name, String shortName) {
        this.professor = professor;
        this.name = name;
        this.shortName = shortName;
        attendingStudents = new HashSet<>();
        paused = professor == null;
    }

    public void addStudent(Student st) {
        attendingStudents.add(st);
        st.attend(this);
    }

    public void removeStudent(Student st) {
        attendingStudents.remove(st);
        st.stopAttending(this);
    }

    public boolean doesStudentAttend(Student st) {
        return attendingStudents.contains(st);
    }

    public void setProfessor(Professor professor, Consumer<Course> professorChangeCallback) {
        if (professorChangeCallback != null) {
            this.professorChangeCallback.accept(this);
        } else if (professor == null) {
            pause();
        } else {
            professor.lectureCourse(this);
        }

        this.professor = professor;
        this.professorChangeCallback = professorChangeCallback;
    }

    public Professor getProfessor() {
        return professor;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public HashSet<Student> getAttendingStudents() {
        return new HashSet<>(attendingStudents);
    }

    public void pause() {
        paused = true;
    }

    public boolean isPaused() {
        return paused;
    }

    public boolean canStart() {
        return !paused || professor != null;
    }

    public boolean start() {
        if (canStart()) {
            paused = false;
            return true;
        }
        return false;
    }
}
