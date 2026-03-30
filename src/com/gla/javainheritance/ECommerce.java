package com.gla.javainheritance;

// Interface
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Abstract class
abstract class Product {
    private int productId;
    private String name;
    private double price;

    // Constructor
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Encapsulation: Getters & Setters
    public int getProductId() {
        return productId;
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

    // Abstract method
    public abstract double calculateDiscount();

    // Display method
    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Base Price: " + price);
    }
}

// Electronics (Taxable)
class Electronics extends Product implements Taxable {

    public Electronics(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18; // 18% tax
    }

    @Override
    public String getTaxDetails() {
        return "Electronics Tax: 18%";
    }
}

// Clothing (Taxable)
class Clothing extends Product implements Taxable {

    public Clothing(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.15; // 15% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05; // 5% tax
    }

    @Override
    public String getTaxDetails() {
        return "Clothing Tax: 5%";
    }
}

// Groceries (Non-taxable)
class Groceries extends Product {

    public Groceries(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }
}

// Main class
public class ECommerce {

    // Polymorphic method
    public static void printFinalPrice(Product product) {
        double price = product.getPrice();
        double discount = product.calculateDiscount();
        double tax = 0;

        if (product instanceof Taxable) {
            tax = ((Taxable) product).calculateTax();
        }

        double finalPrice = price + tax - discount;

        product.displayDetails();
        System.out.println("Discount: " + discount);

        if (product instanceof Taxable) {
            System.out.println(((Taxable) product).getTaxDetails());
            System.out.println("Tax: " + tax);
        } else {
            System.out.println("No Tax Applicable");
        }

        System.out.println("Final Price: " + finalPrice);
        System.out.println("----------------------");
    }

    public static void main(String[] args) {

        Product p1 = new Electronics(1, "Laptop", 50000);
        Product p2 = new Clothing(2, "Shirt", 2000);
        Product p3 = new Groceries(3, "Rice", 1000);

        Product[] products = {p1, p2, p3};

        // Polymorphism in action
        for (Product p : products) {
            printFinalPrice(p);
        }
    }
}
