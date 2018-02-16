package week2.problem12;

public class File implements IFile {

    private static int creationCounter = 0; // pseudo implementation of creation order, see constructor

    private String name;
    private int size;
    private int creationDate;

    public File(String name, int size) {
        this.name = name;
        this.creationDate = creationCounter++;
        this.size = size;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String newName) {
        if (newName != null)
            name = newName;
    }

    @Override
    public int getCreationDate() {
        return this.creationDate;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    public void setSize(int newSize) {
        if (size > 0) size = newSize;
    }
}
