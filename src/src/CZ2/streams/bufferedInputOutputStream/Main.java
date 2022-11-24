package src.CZ2.streams.bufferedInputOutputStream;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        File inputFile = new File("src/CZ2/streams/bufferedInputOutputStream/buffInputStream.txt");
        File outputFile = new File("src/CZ2/streams/bufferedInputOutputStream/buffOutputStreamNew.txt");

        justCopyWithBuffer(inputFile, outputFile);
    }

    private static void justCopyWithBuffer(File inputFile, File outputFile) throws IOException {
        try (
                InputStream input = new BufferedInputStream(new FileInputStream(inputFile));
                OutputStream output = new BufferedOutputStream(new FileOutputStream(outputFile));
        ) {
            byte[] buffer = new byte[28];
            int length = input.read(buffer);
            System.out.printf("Start buffered reading file: [%s]%n", inputFile);
            System.out.printf("Reading buffered values: [%s], chars: [%s], length: [%s]%n",
                    byteArrToString(buffer), toCharString(buffer), length);

            while (length > 0) {
                System.out.printf("Writing buffered values: [%s], chars: [%s]%n",
                        byteArrToString(buffer), toCharString(buffer), length);

                output.write(buffer, 0, length);
                output.flush();

                length = input.read(buffer);
                System.out.printf("Reading buffered values: [%s], chars: [%s], length: [%s]%n",
                        byteArrToString(buffer), toCharString(buffer), length);
            }
        }
    }

    private static String toCharString(byte[] input) {
        char[] arr = new char[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = (char)input[i];
        }
        return replaceNewLine(Arrays.toString(arr));
//        return Arrays.toString(arr);
    }

    private static String byteArrToString(byte[] input) {
        return replaceNewLine(Arrays.toString(input));
//        return Arrays.toString(input);
    }

    private static String replaceNewLine(String input) {
        return input.replace("\n", "\\n");
//        return input;
    }
}
