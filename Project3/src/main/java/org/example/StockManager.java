package org.example;

import java.util.HashMap;
import java.util.Map;

public class StockManager {
    private static StockManager instance;
    private Map<String, Stock> stockList;

    private StockManager() {
        stockList = new HashMap<>();
        initializeStocks();
    }

    public static StockManager getInstance() {
        if (instance == null) {
            instance = new StockManager();
        }
        return instance;
    }

    public Stock getStock(String symbol) {
        return stockList.get(symbol);
    }

    public Stock searchStock(String symbolOrName) {
        for (Stock stock : stockList.values()) {
            if (stock.getSymbol().equalsIgnoreCase(symbolOrName) || stock.getName().equalsIgnoreCase(symbolOrName)) {
                return stock;
            }
        }
        return null;
    }

    public void updateStockPrice(String symbol, double newPrice) {
        if (stockList.containsKey(symbol)) {
            stockList.get(symbol).setPrice(newPrice);
        }
    }

    private void initializeStocks() {
        addStock("AAPL", "Apple Inc.", 150.0, 1000);
        addStock("GOOGL", "Alphabet Inc.", 2700.0, 500);
        addStock("MSFT", "Microsoft Corporation", 300.0, 800);
    }

    private void addStock(String symbol, String name, double price, int quantity) {
        Stock stock = new Stock(symbol, name, price, quantity);
        stockList.put(symbol, stock);
    }
}
