package week5.assignment;

public class University {

    private final String name;

    public University(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
