package com.gla.collection.MapInterface;

import java.util.*;

public class ShoppingCart {

    public static void main(String[] args) {

        // LinkedHashMap preserves insertion order
        Map<String, Double> cart = new LinkedHashMap<>();

        // 1. Add products in order of cart addition
        cart.put("Laptop", 45000.0);
        cart.put("Mouse", 500.0);
        cart.put("Keyboard", 1500.0);
        cart.put("Headphones", 2000.0);
        cart.put("USB Cable", 300.0);

        System.out.println("Cart Items (Insertion Order):");
        displayCart(cart);

        // 2. Simulate removing an item (quantity becomes zero)
        removeItem(cart, "USB Cable");

        System.out.println("\nAfter Removing USB Cable:");
        displayCart(cart);

        // 3. Calculate total bill
        double total = calculateTotal(cart);

        System.out.println("\nTotal Before Discount: ₹" + total);

        // 4. Apply discount if applicable
        double finalAmount = applyDiscount(total);

        System.out.println("Final Amount After Discount (if applied): ₹" + finalAmount);
    }

    // Display items in insertion order
    public static void displayCart(Map<String, Double> cart) {
        for (Map.Entry<String, Double> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " -> ₹" + entry.getValue());
        }
    }

    // Remove item from cart
    public static void removeItem(Map<String, Double> cart, String product) {
        if (cart.containsKey(product)) {
            cart.remove(product);
            System.out.println(product + " removed from cart.");
        } else {
            System.out.println(product + " not found in cart.");
        }
    }

    // Calculate total bill
    public static double calculateTotal(Map<String, Double> cart) {
        double sum = 0;

        for (double price : cart.values()) {
            sum += price;
        }

        return sum;
    }

    // Apply discount if total > 5000
    public static double applyDiscount(double total) {
        if (total > 5000) {
            System.out.println("10% discount applied!");
            return total * 0.9;
        } else {
            System.out.println("No discount applied.");
            return total;
        }
    }
}
