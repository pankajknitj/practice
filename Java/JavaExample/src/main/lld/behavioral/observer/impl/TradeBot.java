package main.lld.behavioral.observer.impl;

import lombok.Data;
import main.lld.behavioral.observer.face.StockObserver;
import main.lld.behavioral.observer.model.StockEvent;

import java.util.HashMap;
import java.util.Map;

import static main.lld.behavioral.observer.model.EventType.STOCK_PRICE_UPDATE;

@Data
public class TradeBot implements StockObserver {
    Map<String, Double> buyThreshold = new HashMap<>();
    Map<String, Double> sellThreshold = new HashMap<>();

    @Override
    public void processStockEvent(StockEvent stockEvent) {
        if(STOCK_PRICE_UPDATE.equals(stockEvent.getEventType())){
            String stockName = stockEvent.getStockName();
            double stockPrice = stockEvent.getStockPrice();
            if(buyThreshold.containsKey(stockName) && stockPrice <= buyThreshold.get(stockName)){
                System.out.println("Buying stock: " + stockName + " at price: " + stockPrice);
            } else if(sellThreshold.containsKey(stockName) && stockPrice >= sellThreshold.get(stockName)){
                System.out.println("Selling stock: " + stockName + " at price: " + stockPrice);
            }
        }
    }
}
