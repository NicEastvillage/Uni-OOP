package week2.assignment.items;

import java.util.Date;

public class Juice extends Item implements Drinkable {

    public static final String NAME = "Juice";

    public Juice(Date expiration) {
        super(NAME, 4, expiration);
    }

    @Override
    public void drink(Date when) {
        if (isExpired(when)) {
            System.out.println("You drank the juice. A bit sour. Was it expired?");
        } else {
            System.out.println("You drank the juice and are filled with energy!");
        }
    }
}
