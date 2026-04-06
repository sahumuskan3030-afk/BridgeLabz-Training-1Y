package com.gla.Wrapper;

public class ShoppingCart {
    public static void main(String[] args) {
        // Prices stored as strings
        String[] prices = {"250", "499", "99", "abc", "150"};

        int total = 0;

        for (String price : prices) {
            try {
                // Convert string to integer
                int value = Integer.parseInt(price);
                total += value;
            } catch (NumberFormatException e) {
                // Handle invalid price
                System.out.println("Invalid price found: " + price);
            }
        }

        System.out.println("Total price: " + total);
    }
}