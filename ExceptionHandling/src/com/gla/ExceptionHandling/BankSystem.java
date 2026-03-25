package com.gla.ExceptionHandling;

// Custom Checked Exception
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Bank Account Class
class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    // Withdraw method
    public void withdraw(double amount) throws InsufficientBalanceException {

        // Unchecked exception
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }

        // Checked exception
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }

        balance -= amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }
}

// Main Class
public class BankSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        try {
            // Test cases (change values to test different scenarios)
            account.withdraw(500);   // valid
            // account.withdraw(1500); // insufficient balance
            // account.withdraw(-100); // invalid amount

        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
