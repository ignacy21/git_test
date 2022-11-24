package src.CZ2.printStreamPrintWriter;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        File file = new File("src/CZ2/printStreamPrintWriter/example.txt");

        try (PrintWriter writer = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(file)))
        ) {
            writer.print(1L);
            writer.write(String.valueOf(1L));

            Car car = new Car("Stefan");
            writer.print(car);

            writer.println();

            writer.println("zajavka");

            writer.printf("some value: [%s]%n", car);
            writer.printf("some value: [%s]%n", car);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
