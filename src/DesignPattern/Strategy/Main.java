package DesignPattern.Strategy;

public class Main {

    static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext(new CreditCardPayment("12345"));
        paymentContext.executePaymentStrategy(5000);

        paymentContext.setPaymentStrategy(new PayPalPayment("abcd"));
        paymentContext.executePaymentStrategy(10000);
    }
}
