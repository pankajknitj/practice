package main.lld.behavioral.template;

import main.lld.behavioral.template.model.Order;

//Here we will define the template method
public abstract class OrderProcessor {
    // template method
    public void processOrder(Order order){
        //specific validation,total calculation and payment processing for each order type
        validateOrder(order);
        double total = calculateTotal(order);
        double payable = applyDiscount(total);
        processPayment(payable);
        sendConfirmation(order);
    }

    protected abstract void validateOrder(Order order);
    protected abstract double calculateTotal(Order order);
    protected abstract void processPayment(double payable);
    //Hook - Optional
    protected double applyDiscount(double total){return total;}
    //common for all
    protected void sendConfirmation(Order order){
        System.out.println("Order confirmation has been sent for order-id: "+order.getOrderId());
    }

}
