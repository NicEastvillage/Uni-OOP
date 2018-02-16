package week2.problem6;

public class Pear implements Fruit {
    @Override
    public String getColor() {
        return "Green";
    }

    @Override
    public String getShape() {
        return "Droplet-shaped";
    }

    @Override
    public int getCalories() {
        return 51;
    }

    @Override
    public void eat() {
        System.out.println("Ew");
    }
}
