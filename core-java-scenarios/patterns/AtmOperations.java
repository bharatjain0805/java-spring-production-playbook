package patterns;

public class AtmOperations {
    private double balance = 10000.0;

    public void executeOperation(String operation, double amount) {
        switch (operation.toLowerCase()) {
            case "withdraw" -> {
                if (amount <= 0) {
                    System.out.println("Invalid withdrawal amount.");
                } else if (amount > balance) {
                    System.out.println("Insufficient funds.");
                } else {
                    balance -= amount;
                    System.out.println("Withdrawn: " + amount + " | Remaining: " + balance);
                }
            }
            case "deposit" -> {
                if (amount <= 0) {
                    System.out.println("Invalid deposit amount.");
                } else {
                    balance += amount;
                    System.out.println("Deposited: " + amount + " | New Balance: " + balance);
                }
            }
            case "check_balance" -> System.out.println("Current Balance: " + balance);
            default -> System.out.println("Invalid Operation Type.");
        }
    }
}