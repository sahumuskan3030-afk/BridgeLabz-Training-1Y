package com.gla.encapsulation;

import java.util.*;

public class ECommercePlatform {

    // Interface
    interface Taxable {
        double calculateTax();
        String getTaxDetails();
    }

    // Abstract Class
    static abstract class Product {
        private int productId;
        private String name;
        protected double price;

        public Product(int productId, String name, double price) {
            this.productId = productId;
            this.name = name;
            this.price = price;
        }

        // Abstract method
        public abstract double calculateDiscount();

        // Encapsulation (Getters & Setters)
        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

    // Electronics Class
    static class Electronics extends Product implements Taxable {

        public Electronics(int id, String name, double price) {
            super(id, name, price);
        }

        @Override
        public double calculateDiscount() {
            return price * 0.10; // 10% discount
        }

        @Override
        public double calculateTax() {
            return price * 0.18; // 18% tax
        }

        @Override
        public String getTaxDetails() {
            return "Electronics Tax: 18%";
        }
    }

    // Clothing Class
    static class Clothing extends Product implements Taxable {

        public Clothing(int id, String name, double price) {
            super(id, name, price);
        }

        @Override
        public double calculateDiscount() {
            return price * 0.20; // 20% discount
        }

        @Override
        public double calculateTax() {
            return price * 0.05; // 5% tax
        }

        @Override
        public String getTaxDetails() {
            return "Clothing Tax: 5%";
        }
    }

    // Groceries Class (No Tax)
    static class Groceries extends Product {

        public Groceries(int id, String name, double price) {
            super(id, name, price);
        }

        @Override
        public double calculateDiscount() {
            return price * 0.05; // 5% discount
        }
    }

    // Polymorphic Method
    public static void calculateFinalPrice(List<Product> products) {
        for (Product p : products) {
            double discount = p.calculateDiscount();
            double tax = 0;

            if (p instanceof Taxable) {
                Taxable t = (Taxable) p;
                tax = t.calculateTax();
                System.out.println(t.getTaxDetails());
            } else {
                System.out.println("No Tax Applicable");
            }

            double finalPrice = p.getPrice() + tax - discount;

            System.out.println("Product: " + p.getName());
            System.out.println("Base Price: " + p.getPrice());
            System.out.println("Discount: " + discount);
            System.out.println("Final Price: " + finalPrice);
            System.out.println("------------------------");
        }
    }

    // Main Method
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Electronics(1, "Laptop", 50000));
        products.add(new Clothing(2, "Shirt", 2000));
        products.add(new Groceries(3, "Rice", 1000));

        calculateFinalPrice(products);
    }
}
