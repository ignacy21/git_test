package src.ZADANIA.zadanie3;

import java.io.*;
import java.nio.file.Files;

public class Main {

    public static void main(String[] args) throws IOException {

        File file = new File("src/ZADANIA/zadanie3/zadanie3.txt");

        howManyBites(file);
    }

    private static void howManyBites(File file) throws IOException {

        float size = Files.size(file.toPath());
        System.out.println("bytes: " + size);
        System.out.println("kb: " + size/1024);
        System.out.println("mb: " + size/1048576);


//        try (InputStream inputStream = new FileInputStream(file)) {
//            byte[] bytes = inputStream.readAllBytes();
//            for (byte aByte : bytes) {
//                System.out.println(aByte);
//            }
//        }
    }
}
