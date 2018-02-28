package week3.assignment;

public class Building2 implements DoorPhone {

    private final int floorCount;

    /** A building with three apartments per floor
     * @param floorCount must be atleast one, but less than ten. */
    public Building2(int floorCount) throws IllegalArgumentException {
        this.floorCount = floorCount;

        if (floorCount <= 0) {
            throw new IllegalArgumentException("There must be at least one floor, but less than ten!");
        }
    }

    /** Call an apartment using the door phone.
     * @param apartment the apartment signature, e.g. "2tv" or "3th". */
    @Override
    public void call(String apartment) throws NoSuchFloorException, IllegalApartmentException {

        // Check if apartment signature is correct length
        if (apartment.length() != 3) {
            throw new IllegalApartmentException(apartment);
        }

        // Check if first character is a digit - floor
        char floorChar = apartment.charAt(0);
        if (!Character.isDigit(floorChar)) {
            throw new IllegalApartmentException(apartment);
        }

        // Check if substring is correct
        String door = apartment.substring(1);
        if (!door.equals("tv") && !door.equals("th")) {
            throw new IllegalApartmentException(apartment);
        }

        // Check if this floor exists
        int floor = Character.getNumericValue(floorChar);
        if (floor > floorCount || floor < 1) {
            throw new NoSuchFloorException(floor);
        }

        // Call the apartment
        System.out.println("Hello!");
    }
}
