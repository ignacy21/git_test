package src.CZ2.serializationDeserialization;

import java.io.Serializable;

public class Persian extends Cat implements Serializable {

    public Persian() {
        System.out.println("Calling Persian default constructor");
    }

    public Persian(String name, String nickName) {
        super(name, nickName);
        System.out.println("Calling Persian normal constructor");
    }
}
