package week7.problem4;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ContentInFile {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Err: First argument should be a file path.");
            return;
        }

        Path path = Paths.get(args[0]);

        if (!Files.exists(path) && !Files.isRegularFile(path) && !Files.isReadable(path)) {
            System.out.println("Err: Could not find/read file at path.");
            return;
        }

        try (BufferedReader bf = Files.newBufferedReader(path)) {
            String line;
            int lineNumber = 1;
            while ((line = bf.readLine()) != null) {
                System.out.println(line);
                lineNumber++;
            }
        } catch (IOException e) {
            System.out.println("Err: Unable to read file.");
        }
    }
}
