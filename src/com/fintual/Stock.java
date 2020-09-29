package com.fintual;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Stock {

    private final Map<LocalDateTime, Double> priceByDate;
    private String name;

    public Stock() {
        this.priceByDate = new HashMap<>();
    }

    public Double getPrice(LocalDateTime date) {
        return priceByDate.get(date);
    }

    public String getName() {
        return name;
    }
}
