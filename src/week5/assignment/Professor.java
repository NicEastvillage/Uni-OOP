package week5.assignment;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return Objects.equals(name, professor.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
