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
        return weight / (height * height);
    }

    public BMIClassification getClassification() {
        double bmi = getBodyMassIndex();
        if (bmi < 18.5) return  BMIClassification.UNDER_WEIGHT;
        if (bmi < 25) return BMIClassification.NORMAL;
        if (bmi < 30) return BMIClassification.OVER_WEIGHT;
        return BMIClassification.OBESE;
    }
}
