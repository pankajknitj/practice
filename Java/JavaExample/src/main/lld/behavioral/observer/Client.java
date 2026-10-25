package main.lld.behavioral.observer;

import main.lld.behavioral.observer.face.StockExchange;
import main.lld.behavioral.observer.face.StockObserver;
import main.lld.behavioral.observer.impl.AlertService;
import main.lld.behavioral.observer.impl.PriceDisplay;
import main.lld.behavioral.observer.impl.StockExchangeImpl;
import main.lld.behavioral.observer.impl.TradeBot;

public class Client {
    public static void main(String[] args) {
        StockExchange stockExchange = new StockExchangeImpl();

        //observers
        StockObserver alertService = new AlertService();
        StockObserver priceDisplay = new PriceDisplay();
        StockObserver tradeBot = new TradeBot();

        //REGISTER OBSERVERS
        stockExchange.registerObserver(alertService);
        stockExchange.registerObserver(priceDisplay);
        stockExchange.registerObserver(tradeBot);

        stockExchange.updateStockPrice("AAPL", 150.0);
        stockExchange.updateStockPrice("GOOGL", 2800.0);
        stockExchange.updateStockPrice("AAPL", 155.0);
    }
}
