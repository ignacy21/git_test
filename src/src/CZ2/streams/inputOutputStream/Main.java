package src.CZ2.streams.inputOutputStream;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        File inputFile = new File("src/CZ2/streams/inputOutputStream/someFileInput.txt");
        File outputFile = new File("src/CZ2/streams/inputOutputStream/someFileOutput.txt");
        justCopyNoBuffer(inputFile, outputFile);
    }

    private static void justCopyNoBuffer(File inputFile, File outputFile) throws IOException {
        try (
                InputStream input = new FileInputStream(inputFile);
                OutputStream output = new FileOutputStream(outputFile);
        ) {
            int value = input.read();
            System.out.printf("Start reading file: [%s]%n", inputFile);
            System.out.printf("Reading value: [%s], char: [%s]%n", value, (char) value);

            while (value != -1) {
                System.out.printf("Writing value: [%s], char[%s]%n", value, (char) value);
                output.write(value);
                value = input.read();
                System.out.printf("Reading value: [%s], char: [%s]%n", value, (char) value);
            }
        }
    }
}
