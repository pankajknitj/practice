package main.lld.behavioral.strategy.impl;

import lombok.Data;
import main.lld.behavioral.strategy.face.PaymentProcessor;

@Data
public class CheckoutService {
    private PaymentProcessor paymentProcessor;

    public CheckoutService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void checkout(double amount) {
        paymentProcessor.processPayment(amount);
    }
}
