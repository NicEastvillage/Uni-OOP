package week2.assignment;

import week2.assignment.items.Item;

import java.util.*;

public class SmartFridge extends Fridge {

    /** The SmartFridge comes with a great set of features, that a normal fridge don't.
     * A SmartFridge can tell you how many of each Item it contains, what is expired and what isn't.
     * It can fetch you fetch the Item closest to the expiration date, and you can even adjust the temperature! */
    public SmartFridge(int size) {
        super(size);
    }

    /** The SmartFridge comes with a great set of features, that a normal fridge don't.
     * A SmartFridge can tell you how many of each Item it contains, what is expired and what isn't.
     * It can fetch you fetch the Item closest to the expiration date, and you can even adjust the temperature! */
    public SmartFridge(int size, double temp) {
        super(size, temp);
    }

    /** Set the temperature. A luxury feature only a SmartFridge have! */
    public void setTemperature(int temp) {
        temperature = temp;
    }

    /** @return an ArrayList of all NOT expired items at the given date */
    public ArrayList<Item> getNotExpiredItems(Date when) {
        ArrayList<Item> notExpired = new ArrayList<>();
        for (Item item : items) {
            if (!item.isExpired(when)) {
                notExpired.add(item);
            }
        }
        return notExpired;
    }

    /** @return an ArrayList of all expired items at the given date */
    public ArrayList<Item> getExpiredItems(Date when) {
        ArrayList expired = new ArrayList<>();
        for (Item item : items) {
            if (item.isExpired(when)) {
                expired.add(item);
            }
        }
        return expired;
    }

    /** @return the Item of given name closest to expiration at the given date */
    public Item getClosestToExpiration(Date when, String name) {
        Item closest = null;
        for (Item item : items) {
            if (item.getName() == name) {
                Date expiration = item.getExpiration();
                if (expiration.before(when)) {
                    if (closest == null || expiration.after(closest.getExpiration())) {
                        closest = item;
                    }
                }
            }
        }
        return closest;
    }

    /** @return the Item closest to expiration at the given date */
    public Item getClosestToExpiration(Date when) {
        Item closest = null;
        for (Item item : items) {
            Date expiration = item.getExpiration();
            if (expiration.before(when)) {
                if (closest == null || expiration.after(closest.getExpiration())) {
                    closest = item;
                }
            }
        }
        return closest;
    }

    /** @return a Map mapping each Item name to a count, so you easily can see how many of each Item you have */
    public Map<String, Integer> getItemCountMap() {
        Map<String, Integer> countMap = new HashMap<>();
        for (Item item : items) {
            String name = item.getName();
            if (!countMap.containsKey(name)) {
                countMap.put(name, 0);
            }

            countMap.put(name, countMap.get(name) + 1);
        }
        return countMap;
    }

    /** Prints a nice list of Items in the fridge and how many where are */
    public void printItems() {
        Map<String, Integer> countMap = getItemCountMap();

        System.out.println("This fridge contains:");
        for (String key : countMap.keySet()) {
            System.out.println(String.format("%2d %s", countMap.get(key), key));
        }
    }
}
