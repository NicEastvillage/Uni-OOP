package week7.problem5;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;

public class CreateWithLines {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Err: First argument should be a file path, and second argument should be a string, and third argument must be a positive number.");
            return;
        }

        Path path = Paths.get(args[0]);
        String line = args[1];
        int times = Integer.valueOf(args[2]);

        if (Files.exists(path)) {
            System.out.println("Err: File already exists.");
            return;
        }

        try (BufferedWriter bw = Files.newBufferedWriter(path, StandardOpenOption.CREATE_NEW)) {
            for (int i = 0; i < times; i++) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Err: Unable to write file.");
            return;
        }

        System.out.println("File created and written!");
    }
}
