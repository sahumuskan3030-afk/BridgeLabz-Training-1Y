package com.gla.encapsulation;

import java.util.*;

public class BankingSystem {

    // Interface
    interface Loanable {
        void applyForLoan(double amount);
        boolean calculateLoanEligibility();
    }

    // Abstract Class
    static abstract class BankAccount {
        private String accountNumber;
        private String holderName;
        protected double balance;

        public BankAccount(String accountNumber, String holderName, double balance) {
            this.accountNumber = accountNumber;
            this.holderName = holderName;
            this.balance = balance;
        }

        // Concrete Methods
        public void deposit(double amount) {
            balance += amount;
        }

        public void withdraw(double amount) {
            if (amount <= balance) {
                balance -= amount;
            } else {
                System.out.println("Insufficient Balance!");
            }
        }

        // Abstract Method
        public abstract double calculateInterest();

        // Encapsulation (Getters)
        public String getAccountNumber() {
            return accountNumber;
        }

        public String getHolderName() {
            return holderName;
        }

        public double getBalance() {
            return balance;
        }
    }

    // Savings Account
    static class SavingsAccount extends BankAccount implements Loanable {
        private double loanAmount;

        public SavingsAccount(String accNo, String name, double balance) {
            super(accNo, name, balance);
        }

        @Override
        public double calculateInterest() {
            return balance * 0.04; // 4% interest
        }

        @Override
        public void applyForLoan(double amount) {
            this.loanAmount = amount;
            System.out.println("Loan applied: " + amount);
        }

        @Override
        public boolean calculateLoanEligibility() {
            return balance > 10000;
        }
    }

    // Current Account
    static class CurrentAccount extends BankAccount implements Loanable {
        private double loanAmount;

        public CurrentAccount(String accNo, String name, double balance) {
            super(accNo, name, balance);
        }

        @Override
        public double calculateInterest() {
            return balance * 0.02; // 2% interest
        }

        @Override
        public void applyForLoan(double amount) {
            this.loanAmount = amount;
            System.out.println("Loan applied: " + amount);
        }

        @Override
        public boolean calculateLoanEligibility() {
            return balance > 50000;
        }
    }

    // Polymorphism Method
    public static void processAccounts(List<BankAccount> accounts) {
        for (BankAccount acc : accounts) {
            System.out.println("Account Holder: " + acc.getHolderName());
            System.out.println("Account Number: " + acc.getAccountNumber());
            System.out.println("Balance: " + acc.getBalance());

            double interest = acc.calculateInterest(); // Polymorphism
            System.out.println("Interest: " + interest);

            if (acc instanceof Loanable) {
                Loanable loan = (Loanable) acc;
                loan.applyForLoan(20000);

                if (loan.calculateLoanEligibility()) {
                    System.out.println("Loan Approved");
                } else {
                    System.out.println("Loan Denied");
                }
            }

            System.out.println("---------------------------");
        }
    }

    // Main Method
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();

        SavingsAccount acc1 = new SavingsAccount("SB123", "Alice", 15000);
        CurrentAccount acc2 = new CurrentAccount("CA456", "Bob", 40000);

        acc1.deposit(5000);
        acc2.withdraw(10000);

        accounts.add(acc1);
        accounts.add(acc2);

        processAccounts(accounts);
    }
}
