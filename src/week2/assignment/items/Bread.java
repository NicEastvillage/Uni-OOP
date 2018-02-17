package week2.assignment.items;

import java.util.Date;

public class Bread extends Item implements Edible {

    public static final String NAME = "Bread";

    public Bread(Date expiration) {
        super(NAME, 3, expiration);
    }

    @Override
    public void eat(Date when) {
        if (isExpired(when)) {
            System.out.println("You ate the bread. It was expired... Gross!");
        } else {
            System.out.println("You ate the bread. All of it. Pieces of bread don't exist in the program, sadly.");
        }
    }
}
