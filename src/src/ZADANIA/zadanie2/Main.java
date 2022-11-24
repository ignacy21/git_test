package src.ZADANIA.zadanie2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Path path = Paths.get("src/ZADANIA/");
        String extensionToSkip = "docx";
        String keyWord = "zajavka";

        printAllFiles(path, keyWord, extensionToSkip);

    }

    private static void printAllFiles(Path name, String keyWord, String extensionToSkip) {
        String txtExtension = "txt";
        try (Stream<Path> walk = Files.walk(name)){
            walk
                    .filter(Files::isRegularFile)
                    .filter(x -> x.toString().contains(keyWord))
                    .filter(x -> extracted(txtExtension, x))
                    .filter(x -> !extracted(extensionToSkip, x))
                    .forEach(System.out::println);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static boolean extracted(String txtExtension, Path x) {
        String pathString = x.toString();
        int i = pathString.indexOf(".");
        String extension = pathString.substring(i, pathString.length() - 1);
        return txtExtension.equals(extension);
    }
}
