package com.gla.generics;
import java.util.*;
class BookCategory {
    String genre;

    public BookCategory(String genre) {
        this.genre = genre;
    }
}

class ClothingCategory {
    String type;

    public ClothingCategory(String type) {
        this.type = type;
    }
}

class GadgetCategory {
    String type;

    public GadgetCategory(String type) {
        this.type = type;
    }
}
class Product<T> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public T getCategory() {
        return category;
    }

    public void display() {
        System.out.println(name + " | Price: " + price + " | Category: " + category.getClass().getSimpleName());
    }
}
class DiscountUtil {

    // Generic method with bounded type
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discount = product.getPrice() * (percentage / 100.0);
        double newPrice = product.getPrice() - discount;
        product.setPrice(newPrice);
    }
}


public class MarketplaceSystem {
    public static void main(String[] args) {

        // Books
        Product<BookCategory> book1 =
                new Product<>("Java Book", 500, new BookCategory("Programming"));

        Product<BookCategory> book2 =
                new Product<>("History Book", 300, new BookCategory("Education"));

        // Clothing
        Product<ClothingCategory> cloth1 =
                new Product<>("T-Shirt", 800, new ClothingCategory("Casual"));

        // Gadgets
        Product<GadgetCategory> gadget1 =
                new Product<>("Smartphone", 20000, new GadgetCategory("Electronics"));

        // Display before discount
        System.out.println("=== BEFORE DISCOUNT ===");
        book1.display();
        cloth1.display();
        gadget1.display();

        // Apply discounts
        DiscountUtil.applyDiscount(book1, 10);
        DiscountUtil.applyDiscount(cloth1, 20);
        DiscountUtil.applyDiscount(gadget1, 5);

        // Display after discount
        System.out.println("\n=== AFTER DISCOUNT ===");
        book1.display();
        cloth1.display();
        gadget1.display();
    }
}

