package com.gla.multithreading;

class BankAccount implements Runnable {
    private String accountHolder;
    private String accountType;

    public BankAccount(String accountHolder, String accountType) {
        this.accountHolder = accountHolder;
        this.accountType = accountType;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println(
                        "User: " + accountHolder +
                                " | Type: " + accountType +
                                " | Thread: " + Thread.currentThread().getName() +
                                " | Priority: " + Thread.currentThread().getPriority() +
                                " | Checking balance (" + i + ")"
                );

                Thread.sleep(2000); // simulate delay (2 seconds)
            }
        } catch (InterruptedException e) {
            System.out.println(accountHolder + " was interrupted.");
        }
    }
}

public class BankSimulation {
    public static void main(String[] args) {

        // Create users
        BankAccount premiumUser = new BankAccount("Alice", "Premium");
        BankAccount regularUser = new BankAccount("Bob", "Regular");
        BankAccount basicUser = new BankAccount("Charlie", "Basic");

        // Create threads
        Thread t1 = new Thread(premiumUser, "Premium-Thread");
        Thread t2 = new Thread(regularUser, "Regular-Thread");
        Thread t3 = new Thread(basicUser, "Basic-Thread");

        // Set priorities
        t1.setPriority(Thread.MAX_PRIORITY);   // 10
        t2.setPriority(Thread.NORM_PRIORITY);  // 5
        t3.setPriority(Thread.MIN_PRIORITY);   // 1

        // Start threads
        t1.start();
        t2.start();
        t3.start();
    }
}
