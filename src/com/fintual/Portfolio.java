package com.fintual;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Portfolio {

    private final List<Stock> stocks;

    public Portfolio() {
        this.stocks = new ArrayList<>();
    }

    public Double getProfit(String stock, LocalDateTime startDate, LocalDateTime endDate) {
        Stock foundStock = stocks.stream()
                .filter(s -> s.getName().equals(stock))
                .findAny()
                .orElse(null);

        Double beginningValue = foundStock.getPrice(startDate);
        Double endingValue = foundStock.getPrice(endDate);

        return (endingValue - beginningValue) / beginningValue;
    }

    public Double getAnnualizedReturn(String stock, LocalDateTime startDate, LocalDateTime endDate, Integer period) {
        Double profit = this.getProfit(stock, startDate, endDate);

        return Math.pow(1 + profit, 1.0 / period) - 1;
    }
}
