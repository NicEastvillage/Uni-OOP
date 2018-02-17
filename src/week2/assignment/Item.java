package week2.assignment;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public abstract class Item {

    private String name;
    private int size;
    private Date expiration;

    public Item(String name, int size, Date expiration) {
        this.name = name;
        this.size = Math.max(0, size);
        this.expiration = expiration;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public Date getExpiration() {
        return expiration;
    }

    public boolean isExpired(Date currentDate) {
        return currentDate.after(expiration);
    }
}
