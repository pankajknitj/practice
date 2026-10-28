package main.lld.behavioral.observer.impl;

import lombok.Data;
import main.lld.behavioral.observer.face.StockObserver;
import main.lld.behavioral.observer.model.StockEvent;

import java.util.HashMap;
import java.util.Map;

import static main.lld.behavioral.observer.model.EventType.STOCK_PRICE_UPDATE;

@Data
//Observer-1
public class AlertService implements StockObserver {
    private Map<String,Double> thresholdMap = new HashMap<>();

    @Override
    public void processStockEvent(StockEvent stockEvent) {
        if(STOCK_PRICE_UPDATE.equals(stockEvent.getEventType())){
            Double threshold = thresholdMap.get(stockEvent.getStockName());
            if(threshold != null && stockEvent.getStockPrice() > threshold){
                System.out.println("Alert: Stock " + stockEvent.getStockName() + " price has crossed the threshold of " + threshold + ". Current price: " + stockEvent.getStockPrice());
            }
        }
    }
}
