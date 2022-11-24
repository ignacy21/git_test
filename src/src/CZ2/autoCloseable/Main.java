package src.CZ2.autoCloseable;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Main {

    public static void main(String[] args) {
        example(Paths.get("someFile.txt"), Paths.get("someNewFile.txt"));
    }

    public static void example(final Path path1, final Path path2) {

        try (Door door = new Door()) {
            System.out.println("Opening the door!");
        } catch (IOException e) {
            System.out.println("Handling door exception " + e.getMessage());
        } finally {
            System.out.println("Calling finally");
        }
    }

    static class Door implements AutoCloseable {

        public Door() {
            System.out.println("Calling door constructor!");
        }

        @Override
        public void close() throws IOException {
            System.out.println("Calling close()!");
        }
    }
}
