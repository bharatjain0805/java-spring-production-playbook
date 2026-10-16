package concurrency;

public class BankAccount {
    private double balance = 5000.0;

    public synchronized boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + " | Remaining: " + balance);
            return true;
        } else {
            System.out.println(Thread.currentThread().getName() + " Insufficient funds.");
            return false;
        }
    }
}
