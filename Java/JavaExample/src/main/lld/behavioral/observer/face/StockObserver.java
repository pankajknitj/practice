package main.lld.behavioral.observer.face;

import main.lld.behavioral.observer.model.StockEvent;

public interface StockObserver {
    void processStockEvent(StockEvent stockEvent);
}
