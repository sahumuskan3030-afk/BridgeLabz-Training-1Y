package com.gla.encapsulation;

import java.util.*;

public class OnlineFoodDeliverySystem {

    // Interface
    interface Discountable {
        double applyDiscount();
        String getDiscountDetails();
    }

    // Abstract Class
    static abstract class FoodItem {
        private String itemName;
        protected double price;
        protected int quantity;

        public FoodItem(String itemName, double price, int quantity) {
            this.itemName = itemName;
            this.price = price;
            this.quantity = quantity;
        }

        // Abstract method
        public abstract double calculateTotalPrice();

        // Concrete method
        public void getItemDetails() {
            System.out.println("Item: " + itemName);
            System.out.println("Price: " + price);
            System.out.println("Quantity: " + quantity);
        }

        // Encapsulation (Getters only)
        public String getItemName() {
            return itemName;
        }
    }

    // Veg Item
    static class VegItem extends FoodItem implements Discountable {

        public VegItem(String name, double price, int quantity) {
            super(name, price, quantity);
        }

        @Override
        public double calculateTotalPrice() {
            return price * quantity;
        }

        @Override
        public double applyDiscount() {
            return calculateTotalPrice() * 0.10; // 10% discount
        }

        @Override
        public String getDiscountDetails() {
            return "Veg Discount: 10%";
        }
    }

    // Non-Veg Item
    static class NonVegItem extends FoodItem implements Discountable {

        public NonVegItem(String name, double price, int quantity) {
            super(name, price, quantity);
        }

        @Override
        public double calculateTotalPrice() {
            double base = price * quantity;
            return base + (base * 0.15); // 15% extra charge
        }

        @Override
        public double applyDiscount() {
            return calculateTotalPrice() * 0.05; // 5% discount
        }

        @Override
        public String getDiscountDetails() {
            return "Non-Veg Discount: 5%";
        }
    }

    // Polymorphism Method
    public static void processOrder(List<FoodItem> items) {
        for (FoodItem item : items) {
            item.getItemDetails();

            double total = item.calculateTotalPrice();
            double discount = 0;

            if (item instanceof Discountable) {
                Discountable d = (Discountable) item;
                discount = d.applyDiscount();
                System.out.println(d.getDiscountDetails());
            }

            double finalAmount = total - discount;

            System.out.println("Total Price: " + total);
            System.out.println("Discount: " + discount);
            System.out.println("Final Amount: " + finalAmount);
            System.out.println("---------------------------");
        }
    }

    // Main Method
    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();

        order.add(new VegItem("Paneer Butter Masala", 250, 2));
        order.add(new NonVegItem("Chicken Biryani", 300, 1));

        processOrder(order);
    }
}
