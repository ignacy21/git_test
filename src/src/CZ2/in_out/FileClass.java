package src.CZ2.in_out;

import java.io.File;

public class FileClass {

    public static void main(String[] args) {
        File file = new File("./src/CZ2/in_out/FileFile.txt");
        System.out.println(file.lastModified());
        file.renameTo(new File(""));

//        if (!file.exists()) {
//            System.out.println("File: " + file + " not available");
//        }
//        System.out.println("file.getAbsolutePath(): " + file.getAbsolutePath());
//        System.out.println("file.getParent(): " + file.getParent());
//
//        if (file.isFile()) {
//            System.out.println("File: " + file + " is file.");
//            System.out.println("file.length(): " + file.length());
//        }
//
//        if (file.isDirectory()) {
//            System.out.println("File: " + file + " is directory.");
//            for (File listFile : file.listFiles()) {
//                System.out.println("Subfile: " + listFile);
//            }
//        }
    }
}
