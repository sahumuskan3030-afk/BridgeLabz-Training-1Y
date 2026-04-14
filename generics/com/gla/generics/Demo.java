package com.gla.generics;

import java.util.*;

// Generic Cart class
class Cart<T> {
    private List<T> items = new ArrayList<>();

    // Add item
    public void addItem(T item) {
        items.add(item);
    }

    // Remove item
    public void removeItem(T item) {
        items.remove(item);
    }

    // Display items
    public void displayItems() {
        for (T item : items) {
            System.out.println(item);
        }
    }
}

// Example product classes
class Electronics {
    String name;

    public Electronics(String name) {
        this.name = name;
    }

    public String toString() {
        return "Electronics: " + name;
    }
}

class Clothing {
    String name;

    public Clothing(String name) {
        this.name = name;
    }

    public String toString() {
        return "Clothing: " + name;
    }
}

// Test
public class Demo {
    public static void main(String[] args) {

        // Electronics cart
        Cart<Electronics> electronicsCart = new Cart<>();
        electronicsCart.addItem(new Electronics("Laptop"));
        electronicsCart.addItem(new Electronics("Mobile"));

        System.out.println("Electronics Cart:");
        electronicsCart.displayItems();

        // Clothing cart
        Cart<Clothing> clothingCart = new Cart<>();
        clothingCart.addItem(new Clothing("Shirt"));
        clothingCart.addItem(new Clothing("Jeans"));

        System.out.println("\nClothing Cart:");
        clothingCart.displayItems();

        // ❌ Not allowed
        // electronicsCart.addItem(new Clothing("T-Shirt")); // Compile-time error
    }
}
