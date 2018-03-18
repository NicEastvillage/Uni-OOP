package week5.assignment;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        University university = new University("Winterspring University");

        // Professors
        Professor prfEdinson = new Professor("Jules Edison");
        Professor prfHawking = new Professor("Valdemar Hawking");
        Professor prfKennedy = new Professor("Alexandre Kennedy");

        // Courses
        Course coCALC = new Course(prfEdinson, "Calculus", "CALC");
        Course coLIAL = new Course(prfEdinson, "Linear Algebra", "LIAL");
        Course coCART = new Course(prfHawking, "Computer Architecture", "CART");
        Course coSTAT = new Course(prfKennedy, "Statistics", "STAT");

        // Students
        Student stMort = new Student("Daniel Mort");
        Student stKristensen = new Student("Emil Kristensen");
        Student stSmidth = new Student("Elia Smidth");
        Student stZakariasen = new Student("David Zakariaseen");
        Student stFriis = new Student("Viola Friis");
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
        stSmidth.complete(coLIAL);

        // Print courses
        for (Course course : university.getCourses()) {
            System.out.println(course.toString() + " is lectured by " + course.getProfessor() + ".");
            Set<Student> students = course.getAttendingStudents();
            if (students.size() == 0) {
                System.out.println("The course has no attending students.");
            } else {
                System.out.println("Attending students are:");
                students.forEach(System.out::println);
            }
        }
    }
}
