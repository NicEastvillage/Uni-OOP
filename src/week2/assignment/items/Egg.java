package week2.assignment.items;

import java.util.Date;

public class Egg extends Item {

    public static final String NAME = "Egg";

    public Egg(Date expiration) {
        super(NAME, 1, expiration);
    }
}
