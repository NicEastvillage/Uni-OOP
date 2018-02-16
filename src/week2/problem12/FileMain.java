package week2.problem12;

public class FileMain {

    public static void main(String[] args) {

        File file1 = new File("apple", 45);
        File file2 = new File("Banana", 1290);
        File file3 = new File("Cat", 123);
        File file4 = new File("Delta", 9);
        File file5 = new File("Elephant", 12403);

        Directory dir1 = new Directory("Fruit");
        dir1.addFile(file1);
        dir1.addFile(file2);

        Directory dir2 = new Directory("Animals");
        dir2.addFile(file5);
        dir2.addFile(file3);

        Directory dir3 = new Directory("Everything");
        dir3.addFile(file4);
        dir3.addFile(dir1); // vi putter mapper i mapper!
        dir3.addFile(dir2);

        System.out.println("DIR 1 oldest: " + dir1.getOldest().getName());
        System.out.println("DIR 2 newest: " + dir2.getNewest().getName());
        System.out.println("DIR 3 size: " + dir3.getSize());
    }
}
