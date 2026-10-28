package main.lld.behavioral.template;

import main.lld.behavioral.template.model.Item;
import main.lld.behavioral.template.model.Order;

public class PrimeOrderProcessing extends OrderProcessor{
    @Override
    protected void validateOrder(Order order) {
        System.out.println("PrimeOrder: Validating order.");
    }

    @Override
    protected double calculateTotal(Order order) {
        System.out.println("PrimeOrder: Calculating total");
        double total = 0;
        for(Item item : order.getItems()){
            total += item.getPrice();
        }
        return total;
    }

    @Override
    protected void processPayment(double payable) {
        System.out.println("PrimeOrder: Processing payment");
    }
    //Discount only for prime customer
    @Override
    protected double applyDiscount(double total){
        System.out.println("PrimeOder: Applying 10% Discount");
        return total * 0.9;
    }
}
