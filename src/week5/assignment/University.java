package week5.assignment;

import java.util.HashMap;
import java.util.HashSet;

public class University {

    private final String name;
    private HashSet<Student> students;
    private HashSet<Professor> professors;
    private HashSet<Course> courses;
    private HashMap<Course, HashSet<Student>> courseAttendingMap;
    private HashMap<Student, HashSet<Course>> studentAttendsCoursesMap;

    public University(String name) {
        this.name = name;
        students = new HashSet<>();
        professors = new HashSet<>();
        courses = new HashSet<>();
        courseAttendingMap = new HashMap<>();
        studentAttendsCoursesMap = new HashMap<>();
    }

    public boolean addCourse(Course course) {
        if (courses.contains(course)) {
            return false;
        }
        courses.add(course);
        professors.add(course.getLecturer());
        return true;
    }

    public void makeStudentAttend(Course course, Student student) {
        if (!courseAttendingMap.containsKey(course)) {
            courseAttendingMap.put(course, new HashSet<>());
        }
        if (!studentAttendsCoursesMap.containsKey(student)) {
            studentAttendsCoursesMap.put(student, new HashSet<>());
        }
        courseAttendingMap.get(course).add(student);
        studentAttendsCoursesMap.get(student).add(course);
    }

    public boolean doesAttend(Student student, Course course) {
        return courseAttendingMap.containsKey(course) &&
                courseAttendingMap.get(course).contains(student);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
