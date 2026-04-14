package com.gla.collection.MapInterface;

import java.util.*;

public class InventoryManagement {

    public static void main(String[] args) {

        // Inventory map: product -> quantity
        Map<String, Integer> inventory = new HashMap<>();

        // 1. Add new products with initial quantities
        inventory.put("Rice", 50);
        inventory.put("Sugar", 30);
        inventory.put("Milk", 20);
        inventory.put("Soap", 15);

        System.out.println("Initial Inventory:");
        printInventory(inventory);

        // 2. Customer buys products (reduce stock)
        buyProduct(inventory, "Rice", 10);
        buyProduct(inventory, "Milk", 20); // should become out of stock

        System.out.println("\nAfter Sales:");
        printInventory(inventory);

        // 3. New shipment arrives (increase stock)
        restockProduct(inventory, "Sugar", 25);
        restockProduct(inventory, "Bread", 40); // new product added via restock

        System.out.println("\nAfter Restocking:");
        printInventory(inventory);

        // 4. Query product stock
        System.out.println("\nStock Queries:");
        queryProduct(inventory, "Sugar");
        queryProduct(inventory, "Milk");
        queryProduct(inventory, "Butter"); // not stocked
    }

    // Reduce quantity when customer buys
    public static void buyProduct(Map<String, Integer> inventory, String product, int quantity) {
        if (!inventory.containsKey(product)) {
            System.out.println(product + " is not available in inventory.");
            return;
        }

        int currentStock = inventory.get(product);
        int newStock = currentStock - quantity;

        if (newStock <= 0) {
            inventory.remove(product); // remove if out of stock
            System.out.println(product + " is now OUT OF STOCK.");
        } else {
            inventory.put(product, newStock);
            System.out.println(quantity + " units of " + product + " sold.");
        }
    }

    // Increase quantity when new shipment arrives
    public static void restockProduct(Map<String, Integer> inventory, String product, int quantity) {
        inventory.put(product, inventory.getOrDefault(product, 0) + quantity);
        System.out.println(product + " restocked with " + quantity + " units.");
    }

    // Query stock availability
    public static void queryProduct(Map<String, Integer> inventory, String product) {
        if (inventory.containsKey(product)) {
            System.out.println(product + " -> " + inventory.get(product) + " units available.");
        } else {
            System.out.println(product + " -> NOT STOCKED");
        }
    }

    // Print full inventory
    public static void printInventory(Map<String, Integer> inventory) {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
