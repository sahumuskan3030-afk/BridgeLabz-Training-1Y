package com.gla.ExceptionHandling;

public class InterestCalculator {

    // Method that uses 'throws' to propagate exception
    public static double calculateInterest(double amount, double rate, int years)
            throws IllegalArgumentException {

        // Using 'throw' to explicitly create an exception
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Amount and rate must be positive");
        }

        // Simple Interest Formula
        return (amount * rate * years) / 100;
    }

    public static void main(String[] args) {
        try {
            double amount = 1000;
            double rate = 5;
            int years = 2;

            double interest = calculateInterest(amount, rate, years);
            System.out.println("Calculated Interest: " + interest);

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: Amount and rate must be positive");
        }
    }
}
