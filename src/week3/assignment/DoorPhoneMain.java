package week3.assignment;

import java.util.Random;
import java.util.Scanner;

public class DoorPhoneMain {

    private static Random rand = new Random();

    public static void main(String[] args) {

        // Setup
        Scanner sc = new Scanner(System.in);
        DoorPhone doorPhone;
        boolean isFirst = true; // used to control the "new" word in instructions
        String cmd;

        // Input loops
        do {
            // Generate building and instruct user
            doorPhone = generateDoorPhone();
            System.out.println(String.format("You approach a %sbulding with a door phone.", isFirst ? "" : "new "));
            System.out.println("Which apartment do you want to call?");
            System.out.println("(write \"next\" for next building or \"quit\" to quit)");

            do {
                cmd = sc.nextLine();

                // Check if cmd is not an exit command
                if (!cmd.equals("next") && !cmd.equals("quit")) {
                    // Let's try calling the apartment!
                    try {
                        doorPhone.call(cmd);
                    } catch (IllegalApartmentException e) {
                        System.out.println("No such apartment exist.");
                    } catch (NoSuchFloorException e) {
                        System.out.println("The building does not have that many floors.");
                    }
                }

            } while (!cmd.equals("next"));

            if (isFirst) isFirst = false;
        } while (!cmd.equals("quit"));

        sc.close();
    }

    /** Generate a building with either two or three apartments per floor and a random floor count. Adds some variance! */
    private static DoorPhone generateDoorPhone() {
        if (rand.nextBoolean()) {
            return new Building2(rand.nextInt(10));
        } else {
            return new Building3(rand.nextInt(10));
        }
    }
}
