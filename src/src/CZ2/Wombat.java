package src.CZ2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Wombat {

    public static void main(String[] args) {
        exception(Paths.get("myCheckingFile.txt"), Paths.get("new_myCheckingFile.txt"));

    }

    private static void exception(final Path path1, final Path path2) {

        try (
                BufferedReader in = Files.newBufferedReader(path1);
                BufferedWriter out = Files.newBufferedWriter(path2);
        ){
            String s = in.readLine();
            out.write(s + "\nsiabadaba");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class MyWombat implements AutoCloseable {
        public MyWombat() {
            System.out.println("Petting my beautiful Wombat");
        }

        @Override
        public void close() throws Exception {
            System.out.println("Pet time is over \n:(");
        }
    }
}
