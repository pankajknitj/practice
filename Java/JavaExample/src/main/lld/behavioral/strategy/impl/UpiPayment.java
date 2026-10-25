package main.lld.behavioral.strategy.impl;

import lombok.Data;
import main.lld.behavioral.strategy.face.PaymentProcessor;

@Data
public class UpiPayment implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing UPI payment of amount: " + amount);
    }
}
