package src.CZ2.serializationDeserialization;

public class Cat {
    private transient String name = "fieldName";
    private String nickName = "fieldNickName";

    static int age = 10;

    {
        this.name = "defaultCATName";
        this.nickName = "defaultCATNickName";
        System.out.println("Calling CAT init block");
    }

    static {
        age = 100;
        System.out.println("Calling CAT static init block");
    }

    public Cat() {
        this.name = "ConstructorCATDefaultName";
        this.nickName = "ConstructorCATDefaultNickName";
        System.out.println("Calling CAT default constructor");
    }

    public Cat(String name, String nickName) {
        this.name = name;
        this.nickName = nickName;
        System.out.println("Calling CAT normal constructor");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
