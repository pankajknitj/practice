package main.lld.behavioral.template;

import main.lld.behavioral.template.model.Item;
import main.lld.behavioral.template.model.Order;
//Concrete processor with override abstract methods
public class StandarrdOrderProcessor extends OrderProcessor {
    @Override
    protected void validateOrder(Order order) {
        System.out.println("Standard Order Processor: Validating order.");
    }

    @Override
    protected double calculateTotal(Order order) {
        System.out.println("Standard Order Processor: Calculating total");
        double total = 0;
        for(Item item : order.getItems()){
            total += item.getPrice();
        }
        return total;
    }

    @Override
    protected void processPayment(double payable) {
        System.out.println("Standard Order Processor: Processing payment");
    }
}
