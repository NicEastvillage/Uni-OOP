package week5.assignment;

import java.util.Date;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        University university = new University("Winterspring University");

        // Professors
        Professor prfEdinson = new Professor("Julie Edison");
        Professor prfHawking = new Professor("Valdemar Hawking");
        Professor prfKennedy = new Professor("Anders Kennedy");

        // Courses
        Course coCALC = new Course(prfEdinson, "Calculus", "CALC");
        Course coLIAL = new Course(prfEdinson, "Linear Algebra", "LIAL");
        Course coCART = new Course(prfHawking, "Computer Architecture", "CART");
        Course coSTAT = new Course(prfKennedy, "Statistics", "STAT");

        // Students
        Student stMort = new Student("Daniel Mort");
        Student stKristensen = new Student("Emil Kristensen");
        Student stSmidth = new Student("Benjamin Smidth");
        Student stZakariasen = new Student("David Zakariaseen");
        Student stFriis = new Student("Sofie Friis");
        Student stKronborg = new Student("Christine Kronborg");
        Student stRadcliff = new Student("Jacob Radcliff");

        // Register
        university.registerProfessor(prfEdinson);
        university.registerProfessor(prfHawking);
        university.registerProfessor(prfKennedy);
        university.addCourse(coCALC);
        university.addCourse(coLIAL);
        university.addCourse(coCART);
        university.addCourse(coSTAT);
        university.registerStudent(stMort);
        university.registerStudent(stKristensen);
        university.registerStudent(stSmidth);
        university.registerStudent(stZakariasen);
        university.registerStudent(stFriis);
        university.registerStudent(stKronborg);
        university.registerStudent(stRadcliff);

        // Attend courses
        university.getCourses().forEach(co -> university.getStudents().forEach(st -> st.attend(co)));
        stSmidth.stopAttending(coCART);
        stFriis.stopAttending(coCALC);
        stKronborg.stopAttending(coCALC);
        stKronborg.stopAttending(coSTAT);

        // Complete courses
        stZakariasen.complete(coCALC);
        stMort.complete(coSTAT);
        stFriis.complete(coSTAT);
        stSmidth.complete(coLIAL);

        // Add homework FIXME Dates are in milliseconds
        coLIAL.addHomework(new Homework(new Date(12307L), "Read page 230-242 in \"Coding the Matrix\"."));
        coLIAL.addHomework(new Homework(new Date(12313L), "Read page 243-260 in \"Coding the Matrix\" + Problem 5.1.10, 5.1.11, 5.1.12, 5.1.13, 5.1.16abc."));
        coSTAT.addHomework(new Homework(new Date(12312L), "Read page 39-44 in \"Analyze - How to Statistics\", and make Problem 1-5 on page 45."));
        coCALC.addHomework(new Homework(new Date(12321L), "Assignment 4, see Moodle."));
        coCART.addHomework(new Homework(new Date(12315L), "Prepare presentations of favorite challenge."));
        coCART.addHomework(new Homework(new Date(12310L), "Read page 410-463 in \"Computer Systems - A Programmers Perspective\"."));

        // Print courses
        System.out.println("//////// Courses //////////");
        for (Course course : university.getCourses()) {
            System.out.println(course.toString() + " is lectured by " + course.getProfessor() + ".");
            Set<Student> students = course.getAttendingStudents();
            if (students.size() == 0) {
                System.out.println("The course has no attending students.");
            } else {
                System.out.println("Attending students are:");
                students.forEach(st -> System.out.println("* " +  st));
            }
        }

        // Print student
        System.out.println("///////// Student /////////");
        System.out.println("The student, \"" + stFriis + "\", attends these Courses:");
        stFriis.getAttendedCourses().forEach(c -> System.out.println("* " + c));
        System.out.println("And has completed these Courses:");
        stFriis.getCompletedCourses().forEach(c -> System.out.println("* " + c));
        System.out.println("Their homework is:");
        for (Course c : stFriis.getAttendedCourses()) {
            for (Homework homework : c.getHomeworkList()) {
                System.out.println("* (" + c.getShortName() + "): " + homework.getDescription());
            }
        }
    }
}
