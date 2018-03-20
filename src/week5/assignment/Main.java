package week5.assignment;

public class Main {
    public static void main(String[] args) {
        University university = new University("Winterspring University");

        // Professors
        Professor prfEdinson = new Professor("Kasper Edison");
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
        Student stSmidth = new Student("Elia Smidth");
        Student stZakariasen = new Student("David Zakariaseen");
        Student stFriis = new Student("Viola Friis");
        Student stKronborg = new Student("Christine Kronborg");
        Student stRadcliff = new Student("Jacob Radcliff");


    }
}
