package main.lld.behavioral.strategy.impl;

import lombok.Data;
import main.lld.behavioral.strategy.face.PaymentProcessor;

@Data
//concrete Strategy-3
public class StripePayment implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Stripe payment of amount: " + amount);
    }
}
