package org.example;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Create users
        UserManager userManager = UserManager.getInstance();
        userManager.registerUser("user1", "password1");
        userManager.registerUser("user2", "password2");

        // Authenticate users
        User user1 = userManager.getUser("user1");
        User user2 = userManager.getUser("user2");

        if (user1 != null && user1.authenticate("password1") && user2 != null && user2.authenticate("password2")) {
            // Display user portfolios
            displayPortfolio(user1);
            displayPortfolio(user2);

            // Execute trades
            executeTrades(user1);
            executeTrades(user2);

            // Display updated portfolios
            displayPortfolio(user1);
            displayPortfolio(user2);

            // View transaction history
            viewTransactionHistory(user1);
            viewTransactionHistory(user2);
        } else {
            System.out.println("Authentication failed for one or more users.");
        }
    }

    private static void displayPortfolio(User user) {
        System.out.println("Portfolio for " + user.getUsername() + ":");
        Map<String, Integer> ownedStocks = user.getPortfolio().getOwnedStocks();
        for (Map.Entry<String, Integer> entry : ownedStocks.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " shares");
        }
        System.out.println("Funds: $" + user.getPortfolio().getFunds());
        System.out.println("------------------------");
    }

    private static void executeTrades(User user) {
        TradingStrategy tradingStrategy = new DayTradingStrategy();
        TradeManager tradeManager = new TradeManager(tradingStrategy);

        tradeManager.executeBuy(user, "AAPL", 10);

        tradeManager.executeSell(user, "GOOGL", 5);
    }

    private static void viewTransactionHistory(User user) {
        System.out.println("Transaction history for " + user.getUsername() + ":");
        List<Transaction> transactionHistory = user.getTransactionHistory();
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction.getType() + " - " +
                    transaction.getStockSymbol() + " - " +
                    transaction.getQuantity() + " shares - $" +
                    transaction.getPrice() + " - " +
                    transaction.getDate());
        }
        System.out.println("------------------------");
    }
}
