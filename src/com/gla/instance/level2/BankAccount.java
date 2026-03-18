package com.gla.instance.level2;


    class BankAccount {

        public String accountNumber;
        protected String accountHolder;
        private double balance;

        public BankAccount(String accountNumber, String accountHolder, double balance) {
            this.accountNumber = accountNumber;
            this.accountHolder = accountHolder;
            this.balance = balance;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public void displayAccountDetails() {
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Account Holder: " + accountHolder);
            System.out.println("Balance: $" + balance);
            System.out.println("----------------------");
        }
    }

    class SavingsAccount extends BankAccount {

        private double interestRate;

        public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
            super(accountNumber, accountHolder, balance);
            this.interestRate = interestRate;
        }

        public void displaySavingsDetails() {
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Account Holder: " + accountHolder);
            System.out.println("Interest Rate: " + interestRate + "%");
            System.out.println("Balance: $" + getBalance());
            System.out.println("----------------------");
        }

        public static void main(String[] args) {
            SavingsAccount sa = new SavingsAccount("ACC123", "Alice Smith", 1000.0, 4.5);
            sa.displaySavingsDetails();
            sa.setBalance(1200.0);
            System.out.println("Updated Balance: $" + sa.getBalance());
        }
    }

