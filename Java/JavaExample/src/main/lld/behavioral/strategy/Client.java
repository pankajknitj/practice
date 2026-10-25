package main.lld.behavioral.strategy;

import main.lld.behavioral.strategy.face.PaymentProcessor;
import main.lld.behavioral.strategy.impl.CheckoutService;
import main.lld.behavioral.strategy.impl.CreditCardPayment;
import main.lld.behavioral.strategy.impl.PaypalPayment;
import main.lld.behavioral.strategy.model.CardDetails;

public class Client {
    public static void main(String[] args) {
        // Create a CheckoutService with PaypalPayment strategy
        PaymentProcessor paypalPayment = new PaypalPayment();
        CheckoutService checkoutService = new CheckoutService(paypalPayment);

        // Process payment using PaypalPayment strategy
        checkoutService.checkout(100.0);

        // Change the strategy to CreditCardPayment
        PaymentProcessor creditCardPayment = new CreditCardPayment(new CardDetails("446646","pk",2443));
        checkoutService.setPaymentProcessor(creditCardPayment);

        // Process payment using CreditCardPayment strategy
        checkoutService.checkout(200.0);
    }
}
