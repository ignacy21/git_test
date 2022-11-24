package src.ZADANIA.zadanie7;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        File file = new File("src/ZADANIA/zadanie7/lorem_Ipsum.txt");

        String str = "asdla salkjd asldkj alsdkj alsdj";
        long l = readLines(file);
        System.out.println(l);
    }


    private static long readLines(File file) {
        List<String> lines = new ArrayList<>();
        List<String> linesWithoutAnyRedundantSigns = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        long wordsCounter = 0;

        try (BufferedReader reader = Files.newBufferedReader(file.toPath())) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (!line.equals("")) {
                    lines.add(line);
                }
            }
            for (String stringLine : lines) {
                String s = stringLine.replaceAll("\"", "");
                String s1 = s.replaceAll(",", "");
                String s2 = s1.replaceAll("\\(", "");
                String s3 = s2.replaceAll("\\)", "");
                String s4 = s3.replaceAll("\\.\\.\\.", "");
                String s5 = s4.replaceAll("\\.", "");
                String s6 = s5.replaceAll("-", "");
                linesWithoutAnyRedundantSigns.add(s6);
            }
            for (String lineWithoutSigns : linesWithoutAnyRedundantSigns) {
                String[] words = lineWithoutSigns.split(" ");
                for (String word : words) {
                    if (!word.equals("")) {
                        stringList.add(word);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        for (String s : stringList) {
            wordsCounter++;

            System.out.printf("%s: %s%n", wordsCounter, s);
        }
        return stringList.size();
    }
}
