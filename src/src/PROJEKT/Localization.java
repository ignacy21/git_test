package src.PROJEKT;

public class Localization {
    private final String country;
    private final String city;

    public Localization(String country, String city) {
        this.country = country;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Localization{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
