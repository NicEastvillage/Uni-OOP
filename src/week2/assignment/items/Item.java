package week2.assignment.items;

import java.util.Date;

public abstract class Item {

    private String name;
    private int size;
    private Date expiration;

    public Item(String name, int size, Date expiration) {
        this.name = name;
        this.size = Math.max(0, size);
        this.expiration = expiration;
    }

    /** @return the name of the item */
    public String getName() {
        return name;
    }

    /** @return the size of the item */
    public int getSize() {
        return size;
    }

    /** @return the date which this item expires */
    public Date getExpiration() {
        return expiration;
    }

    /** @return whether this item is expired or not */
    public boolean isExpired(Date currentDate) {
        return currentDate.after(expiration);
    }

    /** @return whether this item is edible and can be cast to the Edible interface */
    public boolean isEdible() {
        return this instanceof Edible;
    }

    /** @return whether this item is edible and can be cast to the Edible interface */
    public boolean isDrinkable() {
        return this instanceof Drinkable;
    }
}
