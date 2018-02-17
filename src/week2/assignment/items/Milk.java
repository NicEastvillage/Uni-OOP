package week2.assignment.items;

import java.util.Date;

public class Milk extends Item implements Drinkable {

    public static final String NAME = "Milk";

    public Milk(Date expiration) {
        super(NAME, 4, expiration);
    }

    @Override
    public void drink(Date when) {
        if (isExpired(when)) {
            System.out.println("You drank the milk. It tasted awful!!");
        } else {
            System.out.println("You drank the milk. Ahh!");
        }
    }
}
