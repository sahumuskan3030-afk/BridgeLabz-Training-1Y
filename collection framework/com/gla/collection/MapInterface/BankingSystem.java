package com.gla.collection.MapInterface;

import java.util.*;

public class BankingSystem {

    public static void main(String[] args) {

        // Map: Account Number -> Balance
        Map<String, Double> accounts = new HashMap<>();

        // 1. Add new customer accounts
        accounts.put("ACC101", 5000.0);
        accounts.put("ACC102", 12000.0);
        accounts.put("ACC103", 7500.0);
        accounts.put("ACC104", 3000.0);
        accounts.put("ACC105", 20000.0);
        accounts.put("ACC106", 15000.0);

        System.out.println("Initial Accounts:");
        printAccounts(accounts);

        // 2. Deposit operations
        deposit(accounts, "ACC101", 2000);
        deposit(accounts, "ACC104", 500);

        // 3. Withdrawal operations
        withdraw(accounts, "ACC103", 1000);
        withdraw(accounts, "ACC104", 5000); // should fail (insufficient balance)
        withdraw(accounts, "ACC999", 100);  // not found case

        System.out.println("\nAfter Transactions:");
        printAccounts(accounts);

        // 4. Print sorted by descending balance
        System.out.println("\nAccounts Sorted by Balance (Descending):");
        List<Map.Entry<String, Double>> sortedList = new ArrayList<>(accounts.entrySet());

        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        for (Map.Entry<String, Double> entry : sortedList) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // 5. Top 3 customers
        System.out.println("\nTop 3 Customers:");
        for (int i = 0; i < Math.min(3, sortedList.size()); i++) {
            Map.Entry<String, Double> entry = sortedList.get(i);
            System.out.println((i + 1) + ". " + entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Deposit money
    public static void deposit(Map<String, Double> accounts, String acc, double amount) {
        if (!accounts.containsKey(acc)) {
            System.out.println("Account not found: " + acc);
            return;
        }

        accounts.put(acc, accounts.get(acc) + amount);
        System.out.println("Deposited " + amount + " into " + acc);
    }

    // Withdraw money with balance check
    public static void withdraw(Map<String, Double> accounts, String acc, double amount) {
        if (!accounts.containsKey(acc)) {
            System.out.println("Account not found: " + acc);
            return;
        }

        double balance = accounts.get(acc);

        if (balance < amount) {
            System.out.println("Insufficient balance in " + acc);
            return;
        }

        accounts.put(acc, balance - amount);
        System.out.println("Withdrawn " + amount + " from " + acc);
    }

    // Print all accounts
    public static void printAccounts(Map<String, Double> accounts) {
        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
