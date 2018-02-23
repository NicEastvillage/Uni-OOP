package week3.assignment;

public class NoSuchFloorException extends RuntimeException {

    private int floorNumber;

    public NoSuchFloorException(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }
}
