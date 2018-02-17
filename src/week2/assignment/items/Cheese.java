package week2.assignment.items;

import java.util.Date;

public class Cheese extends Item implements Edible {

    public static final String NAME = "Cheese";

    public Cheese() {
        super(NAME, 2, null);
    }

    @Override
    public void eat(Date when) {
        System.out.println("You ate the cheese!");
    }

    @Override
    public boolean isExpired(Date current) {
        // Cheese can't expire
        return false;
    }

    @Override
    public Date getExpiration() {
        // Cheese can't expire
        return new Date(Long.MAX_VALUE);
    }
}
