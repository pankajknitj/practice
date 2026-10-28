package main.lld.behavioral.template;

import main.lld.behavioral.template.model.Item;
import main.lld.behavioral.template.model.Order;

public class InternationalOrderProcessor extends OrderProcessor{
    @Override
    protected void validateOrder(Order order) {
        System.out.println("International order: Validating order.");
    }

    @Override
    protected double calculateTotal(Order order) {
        System.out.println("International order: Calculating total");
        double total = 0;
        for(Item item : order.getItems()){
            total += item.getPrice();
        }
        // In dollar
        return total/80.00;
    }

    @Override
    protected void processPayment(double payable) {
        System.out.println("International order: Processing payment");
    }
}
