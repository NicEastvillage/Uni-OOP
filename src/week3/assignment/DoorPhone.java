package week3.assignment;

public interface DoorPhone {

    /** Call apartment using the door phone.
     * @param apartment apartment signature, e.g. "2tv" or "3th" or "4mf" */
    void call(String apartment) throws NoSuchFloorException, IllegalApartmentException;
}