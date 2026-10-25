package main.lld.behavioral.strategy.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import main.lld.behavioral.strategy.face.PaymentProcessor;
import main.lld.behavioral.strategy.model.CardDetails;

@Data
@AllArgsConstructor
public class CreditCardPayment implements PaymentProcessor {
    private CardDetails cardDetails;
    @Override
    public void processPayment(double amount) {
        if(cardDetails==null){
            throw new IllegalArgumentException("Card details cannot be null");
        }
        System.out.println("Processing credit card payment of amount: " + amount);
        System.out.println("Card Number: " + cardDetails.getCardNumber());
        System.out.println("Card Holder: " + cardDetails.getCardHolder());
    }
}
