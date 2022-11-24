package src.CZ2.serializationDeserialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Ford Mustang", 1969L, List.of(new Door("right"), new Door("left"))));
        cars.add(new Car("BMW 3", 2015L, List.of(new Door("right"), new Door("left"))));
        cars.add(new Car("Mercedes G-class", 2004L, List.of(new Door("right"), new Door("left"))));

        File destiantion = new File("object.whatever");

//        List<Persian> dogs = new ArrayList<>();
//        dogs.add(new Persian("Burek", "Burecki"));
//        dogs.add(new Persian("Fafik", "Fafikowy"));
//        dogs.add(new Persian("Aport", "Aporciński"));
//        dogs.add(new Persian());


//        serialize(cars, destiantion);
//        System.out.println("SERIALIZED\n\n");

        System.out.println("DESERIALIZED START");
        deserialize(destiantion);
        System.out.println("DESERIALIZED END");
    }

    private static void serialize(List<?> objects, File destiantion) throws IOException {
        try (OutputStream outputStream = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(destiantion)))
        ) {
            for (Object object : objects) {
                ((ObjectOutputStream) outputStream).writeObject(object);
            }

        }
    }

    private static List<Car> deserialize(File destiantion) throws IOException, ClassNotFoundException {
        List<Car> result = new ArrayList<>();
        try (InputStream inputStream = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(destiantion)))
        ) {

            while(true) {
                Object object = ((ObjectInputStream) inputStream).readObject();

                if (!(object instanceof Car)) {
                    System.out.println("Object is not Concrete!");
                    continue;
                }
                Car concreteObject = (Car) object;
                System.out.println("Successfully read Object: " + concreteObject);
                result.add(concreteObject);
            }
        } catch (EOFException e) {
            System.out.println("End of File");
        }
        return result;
    }
}
