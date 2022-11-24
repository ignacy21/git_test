package src.PROJEKT;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Comparator;

public class Purchase {
    private final BigDecimal id_porzadkowe_zakupu;
    private final Person person;
    private final Car car;
    private final Localization localization;
    private final LocalDateTime dateTime;

    public Purchase(BigDecimal id_porzadkowe_zakupu, Person person, Car car, Localization localization, LocalDateTime dateTime) {
        this.id_porzadkowe_zakupu = id_porzadkowe_zakupu;
        this.person = person;
        this.car = car;
        this.localization = localization;
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id_porzadkowe_zakupu=" + id_porzadkowe_zakupu +
                ", person=" + person +
                ", car=" + car +
                ", localization=" + localization +
                ", dateTime=" + dateTime +
                '}';
    }


    public Car getCar() {
        return car;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

}
