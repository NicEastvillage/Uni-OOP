package week2.problem7;

public class ColoredPoint3d extends Point3d {
    private String color;

    public ColoredPoint3d(int x, int y, int z, String color) {
        super(x, y, z);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
