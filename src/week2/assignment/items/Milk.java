package week2.assignment.items;

import java.time.Instant;
import java.util.Date;

public class Milk extends Item implements Drinkable {

    public static final String NAME = "Milk";

    public Milk(Date expiration) {
        super(NAME, 4, expiration);
    }

    @Override
    public void drink() {
        if (isExpired(new Date())) {
            System.out.println("You drank the milk. It tasted awful!!");
        } else {
            System.out.println("You drank the milk. Ahh!");
        }
    }
}
