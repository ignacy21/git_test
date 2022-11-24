package src.CZ2.NIO_2.path;

import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

//        try {
//            Path path1 = Paths.get(new URI("file://src/CZ2/NIO_2/fileFile.txt"));
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }

        FileSystem fileSystem = FileSystems.getDefault();
        Path path1 = fileSystem.getPath("src/CZ2/NIO_2/fileFile.txt");
        System.out.println(path1.getClass());

//        Path path1 = Paths.get("src/CZ2/NIO_2/path/oneDirectory/fileFile.txt").toAbsolutePath();
//        Path path2 = Paths.get("src/CZ2/NIO_2/path/twoDirectory/file2.txt").toAbsolutePath();
//
//        System.out.println(path1);
//        System.out.println(path2);
//        System.out.println();
//
//        String toString = path1.toString();
//        int nameCount = path1.getNameCount();
//        Path name = path1.getName(0);
//        Path fileName = path1.getFileName();
//        Path absolutePath = path1.toAbsolutePath();
//        boolean isAbsolute = path1.isAbsolute();
//        Path parent = path1.getParent();
//        Path parent = path1.toAbsolutePath().getParent();
//        Path root = path1.getRoot();
//        Path root = path1.toAbsolutePath().getRoot();
//        Path subpath = path1.subpath(0, 2);
//        Path relativize = path1.relativize(path2);
//        Path resolve = path1.resolve(path2);
//        System.out.println(resolve);
//        Path additionalPath = Paths.get("src//../src/pl//../pl/oneDirectory/fileFile.txt");
//        Path normalize = additionalPath.normalize();
//        System.out.println(normalize);
//        try {
//            Path toRealPath = path1.toRealPath();
//            System.out.println(toRealPath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
