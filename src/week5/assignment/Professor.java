package week5.assignment;

public class Professor implements Person {

    private String name;

    /** A professor is a person that lectures courses at a university */
    public Professor(String name) {
        this.name = name;
    }

    /** @return the name of this Professor. */
    @Override
    public String getName() {
        return name;
    }

    /** @return {@code "Prof. <name>"}*/
    public String getNameWithPrefix() {
        return "Prof. " + name;
    }
}
