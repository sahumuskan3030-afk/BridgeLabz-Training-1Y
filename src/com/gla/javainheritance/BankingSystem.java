package com.gla.javainheritance;

// Interface
interface Loanable {
    void applyForLoan(double amount);
    double calculateLoanEligibility();
}

// Abstract class
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Encapsulation: Getters (no direct field access)
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    // Abstract method
    public abstract double calculateInterest();

    // Display
    public void displayDetails() {
        System.out.println("Account No: " + accountNumber);
        System.out.println("Name: " + holderName);
        System.out.println("Balance: " + balance);
    }
}

// Savings Account
class SavingsAccount extends BankAccount implements Loanable {

    public SavingsAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.04; // 4% interest
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Loan applied (Savings): " + amount);
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 5; // 5x balance
    }
}

// Current Account
class CurrentAccount extends BankAccount implements Loanable {

    public CurrentAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.02; // 2% interest
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Loan applied (Current): " + amount);
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 10; // higher eligibility
    }
}

// Main class
public class BankingSystem {

    public static void processAccount(BankAccount acc) {
        acc.displayDetails();

        double interest = acc.calculateInterest();
        System.out.println("Interest: " + interest);

        if (acc instanceof Loanable) {
            Loanable loan = (Loanable) acc;
            System.out.println("Loan Eligibility: " + loan.calculateLoanEligibility());
        }

        System.out.println("------------------------");
    }

    public static void main(String[] args) {

        BankAccount acc1 = new SavingsAccount("SB101", "Rahul", 50000);
        BankAccount acc2 = new CurrentAccount("CA202", "Anita", 80000);

        // Transactions
        acc1.deposit(5000);
        acc1.withdraw(2000);

        acc2.deposit(10000);
        acc2.withdraw(15000);

        BankAccount[] accounts = {acc1, acc2};

        // Polymorphism
        for (BankAccount acc : accounts) {
            processAccount(acc);
        }
    }
}