package DesignPattern.Strategy;

public class PaymentContext {

    private PaymentStrategy paymentStrategy;

    PaymentContext(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void executePaymentStrategy(double amount){
        paymentStrategy.pay(amount);
    }
}
