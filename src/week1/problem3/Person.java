package week1.problem3;

public class Person {

    private String name;
    private double height;
    private double weight;

    public Person(String name, double height, double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public double getBodyMassIndex() {
        return 0;
    }

    public BMIClassification getClassification() {
        return BMIClassification.NORMAL;
    }
}
