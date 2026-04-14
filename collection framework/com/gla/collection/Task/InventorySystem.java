package com.gla.collection.Task;
import java.util.*;
class Product {
    String name;
    double price;
    int stock;

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return name + " | Price: " + price + " | Stock: " + stock;
    }
}


public class InventorySystem {

    public static void main(String[] args) {

        // 1. Unique product names
        Set<String> productNames = new HashSet<>();

        // 2. Product list
        List<Product> products = new ArrayList<>();

        // 3. Restock queue
        Queue<Product> restockQueue = new LinkedList<>();

        // 4. Stack for undo
        Stack<Product> restockStack = new Stack<>();

        // Add products
        addProduct(productNames, products, new Product("Milk", 50, 5));
        addProduct(productNames, products, new Product("Bread", 30, 2));
        addProduct(productNames, products, new Product("Milk", 60, 10)); // duplicate

        // Identify low stock (threshold = 3)
        for (Product p : products) {
            if (p.stock < 3) {
                restockQueue.offer(p);
            }
        }

        System.out.println("\nRestocking products...\n");

        // Process restock queue
        while (!restockQueue.isEmpty()) {
            Product p = restockQueue.poll();
            System.out.println("Restocking: " + p.name);

            // Save state before restock (for rollback)
            restockStack.push(new Product(p.name, p.price, p.stock));

            // Perform restock
            p.stock += 10;
            System.out.println("Updated Stock: " + p);
        }

        // Undo last restock
        System.out.println("\nUndo last restock...");
        if (!restockStack.isEmpty()) {
            Product lastState = restockStack.pop();

            // Find actual product and restore stock
            for (Product p : products) {
                if (p.name.equals(lastState.name)) {
                    p.stock = lastState.stock;
                    System.out.println("Rollback done: " + p);
                }
            }
        }

        // Final inventory
        System.out.println("\nFinal Inventory:");
        for (Product p : products) {
            System.out.println(p);
        }
    }

    // Add product with duplicate check
    public static void addProduct(Set<String> names, List<Product> products, Product p) {
        if (names.add(p.name)) {
            products.add(p);
            System.out.println("Added product: " + p);
        } else {
            System.out.println("Duplicate product not added: " + p.name);
        }
    }
}
