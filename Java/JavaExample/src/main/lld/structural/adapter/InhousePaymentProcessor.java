package main.lld.structural.adapter;

public class InhousePaymentProcessor implements PaymentProcessor{
    @Override
    public void processPayment(double amount) {

    }

    @Override
    public boolean isPaymentCompleted() {
        return false;
    }

    @Override
    public String getTransactionId() {
        return "";
    }
}
