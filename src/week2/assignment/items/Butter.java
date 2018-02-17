package week2.assignment.items;

import java.util.Date;

public class Butter extends Item implements Edible {

    public static final String NAME = "Butter";

    public Butter(Date expiration) {
        super(NAME, 1, expiration);
    }

    @Override
    public void eat() {
        System.out.println("You ate the butter. Ehm, okay.");
    }
}
