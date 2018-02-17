package week2.assignment;

import week2.assignment.items.Item;

import java.util.ArrayList;

public class Fridge {

    private boolean open = false;
    private double temperature;

    private final int size;

    private ArrayList<Item> items = new ArrayList<>();
    private int spaceLeft;

    /** A fridge can store items in a nice cool temperature (5 degrees). Great for containing food. Size must be at least 1. */
    public Fridge(int size) {
        this(size, 5);
    }

    /** A fridge can store items in a nice temperature. Great for containing food. Size must be at least 1,
     * but the temperature can be anything! (Cool temperatures are recommended) */
    public Fridge(int size, double temp) {
        this.size = Math.max(1, size);
        spaceLeft = size;
        temperature = temp;
    }

    /** @return the temperature inside the fridge */
    public double getTemperature() {
        return temperature;
    }

    /** @return whether the door of the fridge is open */
    public boolean isOpen() {
        return open;
    }

    /** Close the fridge */
    public void close() {
        open = false;
    }

    /** Open the fridge */
    public void open() {
        open = true;
    }

    /** Set the door to the opposite state. Use open() and close() for specific state*/
    public void toggleDoor() {
        open = !open;
    }

    /** Get a list of all the items in the fridge */
    public ArrayList<Item> getItems() {
        return (ArrayList<Item>) items.clone();
    }

    /** Add an item to the fridge */
    public boolean addItem(Item item) {
        if (spaceLeft >= item.getSize()) {
            items.add(item);
            spaceLeft -= item.getSize();
            return true;
        } else {
            System.out.println("Fridge is too full. Could not fit " + item.getName() + ".");
            return false;
        }
    }

    /** Remove an item from the fridge */
    public void removeItem(Item item) {
        if (items.contains(item)) {
            spaceLeft += item.getSize();
            items.remove(item);
        }
    }

    /** @return the number of items with itemName */
    public int countItem(String itemName) {
        int count = 0;
        for (Item item : items) {
            if (item.getName() == itemName) {
                count++;
            }
        }
        return count;
    }

    /** @return the size of the fridge */
    public int getSize() {
        return size;
    }

    /** @return how much space is left in the fridge. This is equal to
     * the size of the fridge minus the size of all stored items */
    public int getSpaceLeft() {
        return spaceLeft;
    }
}
