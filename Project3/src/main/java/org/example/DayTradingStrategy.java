package org.example;

import java.util.Date;
import java.util.Calendar;
import java.util.List;

public class DayTradingStrategy implements TradingStrategy {

    @Override
    public boolean executeBuy(User user, String stockSymbol, int quantity) {
        Stock stock = StockManager.getInstance().getStock(stockSymbol);
        if (stock != null) {
            double totalCost = stock.getPrice() * quantity;
            if (user.getPortfolio().hasSufficientFunds(totalCost)) {
                user.getPortfolio().addStock(stockSymbol, quantity);
                user.getPortfolio().deductFunds(totalCost);

                Transaction buyTransaction = new Transaction(stockSymbol, stock.getName(), quantity, stock.getPrice(), new Date(), TransactionType.BUY);
                user.recordTransaction(buyTransaction);

                return true;
            }
        }
        return false;
    }

    @Override
    public boolean executeSell(User user, String stockSymbol, int quantity) {
        Stock stock = StockManager.getInstance().getStock(stockSymbol);
        if (stock != null && user.getPortfolio().hasStock(stockSymbol, quantity)) {
            double totalEarnings = stock.getPrice() * quantity;

            Transaction lastBuyTransaction = getLastBuyTransaction(user, stockSymbol);

            if (lastBuyTransaction != null) {
                Date buyDate = lastBuyTransaction.getDate();
                Date sellDate = new Date();

                if (isSoldOnSameDay(buyDate, sellDate)) {
                    user.getPortfolio().removeStock(stockSymbol, quantity);
                    user.getPortfolio().addFunds(totalEarnings * 0.95); // 5% charge for selling on a different day

                    Transaction sellTransaction = new Transaction(stockSymbol, stock.getName(), quantity, stock.getPrice(), new Date(), TransactionType.SELL);
                    user.recordTransaction(sellTransaction);

                    return true;
                } else {
                }
            }
        }
        return false;
    }

    private Transaction getLastBuyTransaction(User user, String stockSymbol) {
        List<Transaction> transactionHistory = user.getTransactionHistory();
        for (int i = transactionHistory.size() - 1; i >= 0; i--) {
            Transaction transaction = transactionHistory.get(i);
            if (transaction.getType() == TransactionType.BUY && transaction.getStockSymbol().equals(stockSymbol)) {
                return transaction;
            }
        }
        return null;
    }

    private boolean isSoldOnSameDay(Date buyDate, Date sellDate) {
        Calendar calendarBuy = Calendar.getInstance();
        calendarBuy.setTime(buyDate);

        Calendar calendarSell = Calendar.getInstance();
        calendarSell.setTime(sellDate);

        return calendarBuy.get(Calendar.YEAR) == calendarSell.get(Calendar.YEAR) &&
                calendarBuy.get(Calendar.DAY_OF_YEAR) == calendarSell.get(Calendar.DAY_OF_YEAR);
    }
}
