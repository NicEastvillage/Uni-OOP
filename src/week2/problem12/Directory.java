package week2.problem12;

import java.util.ArrayList;

public class Directory implements IFile {

    private static int creationCounter = 0;

    private String name;
    private int creationDate;

    private ArrayList<IFile> subfiles;

    public Directory(String name) {
        this.name = name;
        this.creationDate = creationCounter++;

        subfiles = new ArrayList<>();
    }

    public void addFile(IFile file) {
        subfiles.add(file);
    }

    public IFile getNewest() {
        if (subfiles.size() == 0) return null;

        IFile newest = subfiles.get(0);

        for (IFile subfile : subfiles) {
            if (newest.getCreationDate() < subfile.getCreationDate()) {
                newest = subfile;
            }
        }

        return newest;
    }

    public IFile getOldest() {
        if (subfiles.size() == 0) return null;

        IFile oldest = subfiles.get(0);

        for (IFile subfile : subfiles) {
            if (oldest.getCreationDate() > subfile.getCreationDate()) {
                oldest = subfile;
            }
        }

        return oldest;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String newName) {
        this.name = newName;
    }

    @Override
    public int getSize() {
        int sum = 0;
        for (IFile subfile : subfiles) {
            sum += subfile.getSize();
        }
        return sum;
    }

    @Override
    public int getCreationDate() {
        return creationDate;
    }
}
