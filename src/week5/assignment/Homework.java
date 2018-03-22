package week5.assignment;

import java.util.Date;
import java.util.Objects;

public class Homework implements Comparable<Homework> {

    private Date dueDate;
    private String description;

    /** Homework is a terrific thing invented to drain Students spare time (I've heard).
     * Homework must have a due date and a description. */
    public Homework(Date dueDate, String description) {
        this.dueDate = dueDate;
        this.description = description;
    }

    /** @return a Date describing when this Homework is due. */
    public Date getDueDate() {
        return dueDate;
    }

    /** @return a String with the details of this piece of Homework. */
    public String getDescription() {
        return description;
    }

    /** Compare two pieces of Homework.
     * @return positive if {@code this}' hand-in date is before {@that}'s hand-in date, negative if {@code this}'
     * hand-in date is after {@that}'s hand-in date, and 0 if the two pieces of Homework have the exact same due date.*/
    @Override
    public int compareTo(Homework that) {
        return (int) (dueDate.getTime() - that.dueDate.getTime());
    }

    /** Homework is equal when they have the same description and the same due date. */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Homework homework = (Homework) o;
        return Objects.equals(dueDate, homework.dueDate) &&
                Objects.equals(description, homework.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dueDate, description);
    }
}
