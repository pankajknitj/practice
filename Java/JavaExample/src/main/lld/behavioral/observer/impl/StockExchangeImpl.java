package main.lld.behavioral.observer.impl;

import lombok.Data;
import main.lld.behavioral.observer.face.StockExchange;
import main.lld.behavioral.observer.face.StockObserver;
import main.lld.behavioral.observer.model.EventType;
import main.lld.behavioral.observer.model.StockEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//this should be a singleton class, but for simplicity, we are not implementing singleton pattern here
@Data
public class StockExchangeImpl implements StockExchange {
    private List<StockObserver> observers = new ArrayList<>();
    private Map<String, Double> stockPrices = new HashMap<>();

    @Override
    public void registerObserver(StockObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(StockObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(StockEvent event) {
        observers.forEach(obs -> obs.processStockEvent(event));
    }

    @Override
    public void registerStock(String stockName, double price) {
        stockPrices.put(stockName,price);

        //notify: notify observers when a new stock is registered
        StockEvent stockEvent = new StockEvent(stockName, price, EventType.STOCK_REGISTRATION);
        notifyObservers(stockEvent);
    }

    @Override
    public void updateStockPrice(String stockName, double price) {
        stockPrices.put(stockName,price);

        //notify: notify observers when a new stock is registered
        StockEvent stockEvent = new StockEvent(stockName, price, EventType.STOCK_PRICE_UPDATE);
        notifyObservers(stockEvent);
    }

    @Override
    public void unregisterStock(String stockName) {
        stockPrices.remove(stockName);

        //notify: notify observers when a new stock is registered
        StockEvent stockEvent = new StockEvent(stockName,0.0, EventType.STOCK_DELISTING);
        notifyObservers(stockEvent);
    }

    @Override
    public Map<String, Double> getStockPrices() {
        return stockPrices;
    }
}
