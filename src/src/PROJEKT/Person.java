package src.PROJEKT;

public class Person {

    private final String imie;
    private final String nazwisko;
    private final String email;
    private final String ip;

    public Person(String imie, String nazwisko, String email, String ip) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "Person{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", email='" + email + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
