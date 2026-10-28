package main.lld.behavioral.observer.face;

import main.lld.behavioral.observer.model.StockEvent;

import java.util.Map;

//subject interface
public interface StockExchange {
    void registerObserver(StockObserver observer);
    void removeObserver(StockObserver observer);
    void notifyObservers(StockEvent event);
    void registerStock(String stockName, double price);
    void updateStockPrice(String stockName, double price);
    void unregisterStock(String stockName);
    Map<String,Double> getStockPrices();
}
