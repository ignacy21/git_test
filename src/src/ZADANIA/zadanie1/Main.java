package src.ZADANIA.zadanie1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        Path path1 = Paths.get("src/ZADANIA");
        Path path2 = Paths.get("src/ZADANIA/zadanie1/file2.txt");

        findAndPrintAllFilesAboveThePath(path1);

//        File[] files = toFile.listFiles();
//        for (File file : files) {
//            if (file.isFile()) {
//                Files.readAllLines(file.toPath());
//            }
//            if (file.isDirectory()) {
//
//            }
//            System.out.println(file);
//        }

//        Path path1 = path.toAbsolutePath();
//        System.out.println(path1);

//        List<String> stringList = Files.readAllLines(path);


    }

    private static void someMethod(Path path) {
        File toFile = path.toFile();
        System.out.println("path: " + toFile);

        boolean directory = toFile.isAbsolute();
        System.out.println("isAbsolute: " + directory);
        boolean hidden = toFile.isHidden();
        System.out.println("isHidden: " + hidden);
        String parent = toFile.getParent();
        System.out.println("getParent: " + parent);

        File[] files = toFile.listFiles();
        System.out.println(Arrays.toString(files));
        String[] list = toFile.list();
        System.out.println(Arrays.toString(list));


        System.out.println();
    }

    private static void findAndPrintAllFilesAboveThePath(Path path) throws IOException {
        File toFile = path.toFile();
        File[] files = toFile.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                List<String> stringList = Files.readAllLines(file.toPath());
                System.out.println(file + ": ");
                System.out.println(stringList);
            }
            if (!file.isFile()) {
                findAndPrintAllFilesAboveThePath(file.toPath());
            }

        }
    }
}
