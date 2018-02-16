package week2.problem6;

public class Apple implements Fruit {

    @Override
    public String getColor() {
        return "greenish red";
    }

    @Override
    public String getShape() {
        return "Sphere";
    }

    @Override
    public int getCalories() {
        return 52;
    }

    @Override
    public void eat() {
        System.out.println("You ate the apple!");
    }
}
