package org.example;

public class TradeManager {
    private TradingStrategy tradingStrategy;

    public TradeManager(TradingStrategy tradingStrategy) {
        this.tradingStrategy = tradingStrategy;
    }

    public void setTradingStrategy(TradingStrategy tradingStrategy) {
        this.tradingStrategy = tradingStrategy;
    }

    public boolean executeBuy(User user, String stockSymbol, int quantity) {
        return tradingStrategy.executeBuy(user, stockSymbol, quantity);
    }

    public boolean executeSell(User user, String stockSymbol, int quantity) {
        return tradingStrategy.executeSell(user, stockSymbol, quantity);
    }
}
