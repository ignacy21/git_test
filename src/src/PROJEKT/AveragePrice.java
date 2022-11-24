package src.PROJEKT;

import java.math.BigDecimal;

public class AveragePrice {

    private final Integer idPorzadkowe;
    private final String company;
    private final String model;
    private final BigDecimal averagePrice;
    private final BigDecimal totalCost;
    private final Integer CarAmount;

    public AveragePrice(Integer idPorzadkowe, String company, String model, BigDecimal totalCost, Integer carAmount) {
        this.idPorzadkowe = idPorzadkowe;
        this.company = company;
        this.model = model;
        this.averagePrice = totalCost.divide(BigDecimal.valueOf(carAmount));
        this.totalCost = totalCost;
        CarAmount = carAmount;
    }
}
