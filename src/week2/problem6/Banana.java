package week2.problem6;

public class Banana implements Fruit {

    @Override
    public String getColor() {
        return "Yellow";
    }

    @Override
    public String getShape() {
        return "Long and curved";
    }

    @Override
    public int getCalories() {
        return 90;
    }

    @Override
    public void eat() {
        System.out.println("Mhmmmm");
    }
}
