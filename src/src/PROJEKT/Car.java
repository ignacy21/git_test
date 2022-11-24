package src.PROJEKT;

import java.math.BigDecimal;

public class Car {

    private final String color;
    private final String vin;
    private final String company;
    private final String model;
    private final String model_year;
    private final BigDecimal price;

    public Car(String color, String vin, String company, String model, String model_year, BigDecimal price) {
        this.color = color;
        this.vin = vin;
        this.company = company;
        this.model = model;
        this.model_year = model_year;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", vin='" + vin + '\'' +
                ", company='" + company + '\'' +
                ", model='" + model + '\'' +
                ", model_year='" + model_year + '\'' +
                ", price=" + price +
                '}';
    }

    public String getCompany() {
        return company;
    }

    public String getModel() {
        return model;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
