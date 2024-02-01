package org.example;

import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    private Map<String, Integer> ownedStocks;
    private double funds;

    public Portfolio() {
        ownedStocks = new HashMap<>();
        funds = 0.0;
    }

    public void addStock(String stockSymbol, int quantity) {
        ownedStocks.put(stockSymbol, ownedStocks.getOrDefault(stockSymbol, 0) + quantity);
    }

    public void removeStock(String stockSymbol, int quantity) {
        int currentQuantity = ownedStocks.getOrDefault(stockSymbol, 0);
        if (currentQuantity - quantity > 0) {
            ownedStocks.put(stockSymbol, currentQuantity - quantity);
        } else {
            ownedStocks.remove(stockSymbol);
        }
    }

    public Map<String, Integer> getOwnedStocks() {
        return ownedStocks;
    }

    public boolean hasSufficientFunds(double requiredAmount) {
        return funds >= requiredAmount;
    }

    public boolean hasStock(String stockSymbol, int requiredQuantity) {
        int currentQuantity = ownedStocks.getOrDefault(stockSymbol, 0);
        return currentQuantity >= requiredQuantity;
    }

    public void deductFunds(double amount) {
        funds -= amount;
    }

    public void addFunds(double amount) {
        funds += amount;
    }

    public double getFunds() {
        return funds;
    }
}
