package com.gla.collection.Task;

import java.util.Objects;
import java.util.*;
class Account {
    int accountId;
    String name;
    double balance;

    public Account(int accountId, String name, double balance) {
        this.accountId = accountId;
        this.name = name;
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account acc = (Account) o;
        return accountId == acc.accountId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId);
    }

    @Override
    public String toString() {
        return "Account{id=" + accountId + ", name=" + name + ", balance=" + balance + "}";
    }
}
class Transaction {
    int transactionId;
    int accountId;
    String type; // "deposit" or "withdraw"
    double amount;

    public Transaction(int transactionId, int accountId, String type, double amount) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.type = type;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{id=" + transactionId + ", accId=" + accountId +
                ", type=" + type + ", amount=" + amount + "}";
    }
}


public class BankingSystem {

    public static void main(String[] args) {

        // 1. Valid accounts (Set)
        Set<Account> accounts = new HashSet<>();
        accounts.add(new Account(1, "Alice", 1000));
        accounts.add(new Account(2, "Bob", 500));

        // 2. Pending transactions (Queue)
        Queue<Transaction> transactionQueue = new LinkedList<>();
        transactionQueue.offer(new Transaction(101, 1, "deposit", 200));
        transactionQueue.offer(new Transaction(102, 2, "withdraw", 100));
        transactionQueue.offer(new Transaction(103, 3, "deposit", 300)); // invalid account

        // 3. Completed transactions (List)
        List<Transaction> completedTransactions = new ArrayList<>();

        // 4. Stack for rollback
        Stack<Transaction> rollbackStack = new Stack<>();

        System.out.println("Processing Transactions...\n");

        while (!transactionQueue.isEmpty()) {
            Transaction tx = transactionQueue.poll();

            // Validate account
            Account account = findAccount(accounts, tx.accountId);

            if (account == null) {
                System.out.println("Invalid account for " + tx);
                continue;
            }

            System.out.println("Processing " + tx);

            // Execute transaction
            boolean success = processTransaction(account, tx);

            if (success) {
                completedTransactions.add(tx);
                rollbackStack.push(tx);
                System.out.println("Transaction successful.");
            } else {
                System.out.println("Transaction failed.");
            }
        }

        // 5. Rollback last transaction
        System.out.println("\nRolling back last transaction...");
        if (!rollbackStack.isEmpty()) {
            Transaction lastTx = rollbackStack.pop();
            Account account = findAccount(accounts, lastTx.accountId);
            rollbackTransaction(account, lastTx);
            System.out.println("Rollback completed for " + lastTx);
        }

        // Display final account states
        System.out.println("\nFinal Account Details:");
        for (Account acc : accounts) {
            System.out.println(acc);
        }
    }

    // Find account by ID
    public static Account findAccount(Set<Account> accounts, int accountId) {
        for (Account acc : accounts) {
            if (acc.accountId == accountId) {
                return acc;
            }
        }
        return null;
    }

    // Process transaction
    public static boolean processTransaction(Account acc, Transaction tx) {
        if (tx.type.equals("deposit")) {
            acc.balance += tx.amount;
            return true;
        } else if (tx.type.equals("withdraw")) {
            if (acc.balance >= tx.amount) {
                acc.balance -= tx.amount;
                return true;
            }
        }
        return false;
    }

    // Rollback transaction
    public static void rollbackTransaction(Account acc, Transaction tx) {
        if (tx.type.equals("deposit")) {
            acc.balance -= tx.amount;
        } else if (tx.type.equals("withdraw")) {
            acc.balance += tx.amount;
        }
    }
}
