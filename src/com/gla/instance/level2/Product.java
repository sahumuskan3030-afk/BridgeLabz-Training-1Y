package com.gla.instance.level2;



    public class Product {

        // Instance variables
        private String productName;
        private double price;

        // Class variable (shared among all objects)
        private static int totalProducts = 0;

        // Constructor
        public Product(String productName, double price) {
            this.productName = productName;
            this.price = price;
            totalProducts++; // Increment when a new product is created
        }

        // Instance method
        public void displayProductDetails() {
            System.out.println("Product Name: " + productName);
            System.out.println("Price: $" + price);
            System.out.println("----------------------");
        }

        // Class method (static method)
        public static void displayTotalProducts() {
            System.out.println("Total Products Created: " + totalProducts);
        }

        // Main method for testing
        public static void main(String[] args) {

            Product p1 = new Product("Laptop", 800.00);
            Product p2 = new Product("Phone", 500.00);
            Product p3 = new Product("Headphones", 150.00);

            p1.displayProductDetails();
            p2.displayProductDetails();
            p3.displayProductDetails();

            Product.displayTotalProducts(); // Calling class method
        }
    }

