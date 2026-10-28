package main.lld.behavioral.observer.impl;

import lombok.Data;
import main.lld.behavioral.observer.face.StockObserver;
import main.lld.behavioral.observer.model.StockEvent;

import java.util.HashMap;
import java.util.Map;

@Data
//observer-2
public class PriceDisplay implements StockObserver {
    Map<String, Double> stockPrices = new HashMap<>();

    public PriceDisplay(){
        displayStockPrices();
    }

    @Override
    public void processStockEvent(StockEvent stockEvent) {
        switch (stockEvent.getEventType()){
            case STOCK_REGISTRATION:
                stockPrices.put(stockEvent.getStockName(), stockEvent.getStockPrice());
                System.out.println("Registered stock: " + stockEvent.getStockName() + " with price: " + stockEvent.getStockPrice());
                break;
            case STOCK_PRICE_UPDATE:
                stockPrices.put(stockEvent.getStockName(), stockEvent.getStockPrice());
                System.out.println("Updated stock: " + stockEvent.getStockName() + " with new price: " + stockEvent.getStockPrice());
                break;
            case STOCK_DELISTING:
                stockPrices.remove(stockEvent.getStockName());
                System.out.println("Unregistered stock: " + stockEvent.getStockName());
                break;
        }
        displayStockPrices();
    }

    private void displayStockPrices() {
        for (Map.Entry<String, Double> entry : stockPrices.entrySet()) {
            String stockName = entry.getKey();
            double stockPrice = entry.getValue();
            System.out.println("Stock: " + stockName + ", Price: " + stockPrice);
        }

    }
}
