package week7.assignment;

import java.io.IOException;
import java.nio.file.*;

public class DirectorySize {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Err: First argument must be a path to a directory.");
            return;
        }

        Path rootPath = Paths.get(args[0]);

        if (!Files.exists(rootPath)) {
            System.out.println("Err: Directory does not exist.");
            return;
        }

        if (!Files.isDirectory(rootPath, LinkOption.NOFOLLOW_LINKS)) {
            System.out.println("Err: Path is not a directory.");
            return;
        }

        try {
            long size = getSizeOfDirectoryRecursively(rootPath);
            System.out.println("Directory: " + rootPath);
            System.out.println("size: " + size);

        } catch (IOException e) {
            System.out.println("Err: Could not calculate directory size.");
        }
    }

    static long getSizeOfDirectoryRecursively(Path path) throws IOException {
        return Files.list(path)
                .mapToLong(p -> {
                    if (Files.isRegularFile(p)) {
                        try {
                            return Files.size(p);
                        } catch (IOException e) {
                            return 0;
                        }
                    }
                    else if (!Files.isSymbolicLink(p)) {
                        try {
                            return getSizeOfDirectoryRecursively(p);
                        } catch (IOException e) {
                            return 0;
                        }
                    } else {
                        return 0;
                    }
                })
                .sum();
    }
}
