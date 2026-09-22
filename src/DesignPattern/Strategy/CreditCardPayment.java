package DesignPattern.Strategy;

public class CreditCardPayment implements PaymentStrategy{

    private String  cardNumber;

    CreditCardPayment(String cardNumber){
        this. cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println(amount + " paid using the credit card number " + cardNumber);
    }
}
