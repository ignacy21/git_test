package src.CZ2.serializationDeserialization;

import java.io.Serializable;
import java.util.List;

public class Car implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String name;
    private final Long year;
    private final transient List<Door> doors;

    private String someNull;

    public Car(String name, Long year, List<Door> doors) {
        this.name = name;
        this.year = year;
        this.doors = doors;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", doors=" + doors +
                ", someNull='" + someNull + '\'' +
                '}';
    }
}
