package patterns;

public interface PaymentMethod {
    void pay(double amount);
    String getName();
}

class UpiPayment implements PaymentMethod {
    public void pay(double amount) { System.out.println("Processing UPI payment: " + amount); }
    public String getName() { return "UPI"; }
}

class CardPayment implements PaymentMethod {
    public void pay(double amount) { System.out.println("Processing Card payment: " + amount); }
    public String getName() { return "CARD"; }
}
