package org.example;

import java.util.Date;

public class Transaction {
    private String stockSymbol;
    private String stockName;
    private int quantity;
    private double price;
    private Date date;
    private TransactionType type;

    public Transaction(String stockSymbol, String stockName, int quantity, double price, Date date, TransactionType type) {
        this.stockSymbol = stockSymbol;
        this.stockName = stockName;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
        this.type = type;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public String getStockName() {
        return stockName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public Date getDate() {
        return date;
    }

    public TransactionType getType() {
        return type;
    }
}

