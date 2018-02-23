package week3.assignment;

public class IllegalApartmentException extends RuntimeException {

    private String apartment;

    public IllegalApartmentException(String apartment) {
        this.apartment = apartment;
    }

    public String getApartment() {
        return apartment;
    }
}
