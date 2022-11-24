package src.ZADANIA.zadanie6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        File file = new File("src/ZADANIA/zadanie6/lorem_Ipsum.txt");


        List<String> stringList = readFile(file);
        reWriteFileWithUpperCase(file, stringList);
    }

    private static List<String> readFile(File file) throws IOException {
        List<String> resultList = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(file.toPath())) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                resultList.add(line);
            }
        }
        return resultList;
    }

    private static void reWriteFileWithUpperCase(File file, List<String> stringList) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(file.toPath())) {
            for (String line : stringList) {
                String toUpperCase = line.toUpperCase();
                writer.write(toUpperCase);
                writer.newLine();
            }
        }
    }
}
