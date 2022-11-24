package src.CZ2.supressedExceptions;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        try (Door door = new Door()) {
            System.out.println("Opening the door!");
            throw new RuntimeException("Exception while opening the door");
        } catch (Exception e) {
            System.out.println("Handling door exception " + e.getMessage());
            for (Throwable throwable : e.getSuppressed()) {
                System.out.println("Suppressed: " + throwable.getMessage());
            }
            e.printStackTrace();
            System.err.println("\n");
        } finally {
            System.out.println("Calling finally\n\n");
            throw new RuntimeException("Exception In Finally");
        }
    }

    static class Door implements AutoCloseable {

        public Door() {
            System.out.println("Calling door constructor!");
        }

        @Override
        public void close() throws Exception {
            System.out.println("Calling close()!");
            throw new RuntimeException("close() exception");
        }
    }
}
