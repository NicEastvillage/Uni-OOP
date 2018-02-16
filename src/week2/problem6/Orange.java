package week2.problem6;

public class Orange implements Fruit {

    @Override
    public String getColor() {
        return "Orange";
    }

    @Override
    public String getShape() {
        return "Sphere";
    }

    @Override
    public int getCalories() {
        return 61;
    }

    @Override
    public void eat() {
        System.out.println("You ate the orange");
    }
}
