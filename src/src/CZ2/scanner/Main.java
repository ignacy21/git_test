package src.CZ2.scanner;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner =  new Scanner(System.in);
        System.out.println("Enter some data\n");

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            System.out.println("Entered: " + line);

            if ("done".equals(line)) {
                break;
            }
        }
    }
}
