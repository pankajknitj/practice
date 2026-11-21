package main.lld.structural.adapter;

public interface PaymentProcessor {
    void processPayment(double amount);
    boolean isPaymentCompleted();
    String getTransactionId();
}
