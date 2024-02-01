package org.example;

public interface TradingStrategy {
    boolean executeBuy(User user, String stockSymbol, int quantity);
    boolean executeSell(User user, String stockSymbol, int quantity);
}
