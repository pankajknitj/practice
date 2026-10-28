package main.lld.behavioral.template;

import main.lld.behavioral.template.model.Item;
import main.lld.behavioral.template.model.Order;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>(List.of(new Item("mac",150000), new Item("charger",10000)));
        Order order = new Order(1001, items);

        OrderProcessor standardOP = new StandarrdOrderProcessor();
        standardOP.processOrder(order);

        OrderProcessor primeOP = new PrimeOrderProcessing();
        primeOP.processOrder(order);

        OrderProcessor internationalOP = new InternationalOrderProcessor();
        internationalOP.processOrder(order);
    }

}
