package patterns;

public abstract class BankAccountTemplate {
    protected double balance;

    public void deposit(double amount) { this.balance += amount; }
    public abstract double calculateInterest();
}

class SavingsAccount extends BankAccountTemplate {
    public double calculateInterest() { return this.balance * 0.04; }
}

class CurrentAccount extends BankAccountTemplate {
    public double calculateInterest() { return 0.0; } // No interest
}
