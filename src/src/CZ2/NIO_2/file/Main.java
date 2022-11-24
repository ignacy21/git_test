package src.CZ2.NIO_2.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("src/CZ2/NIO_2/file/fileFile.txt");
        Path path1 = Paths.get("src/CZ2/NIO_2/file/copyFile.txt");

        Path catalog = Paths.get("src/CZ2/NIO_2/file/catalog");
        Path catalogCatalog = Paths.get("src/CZ2/NIO_2/file/catalog/nextCatalog");
        Path catalogCatalogTXT = Paths.get("src/CZ2/NIO_2/file/catalog/nextCatalog/fileFile.txt");

//        Files.exists(path);
//        Files.createDirectory(catalog);
//        Files.createDirectories(catalogCatalog);
//        Files.move(path, catalogCatalogTXT);
//        Files.copy(path, path1);
        Files.delete(catalogCatalog);
//        Files.deleteIfExists(path1);
        List<String> stringList = Files.readAllLines(path);
        for (String s : stringList) {
            System.out.println(s);
        }



    }
}
