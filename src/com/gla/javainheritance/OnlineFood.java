package com.gla.javainheritance;

// Interface
interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

// Abstract class
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    // Constructor
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Encapsulation: Getters
    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        }
    }

    // Abstract method
    public abstract double calculateTotalPrice();

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }
}

// Veg Item
class VegItem extends FoodItem implements Discountable {

    public VegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity(); // no extra charge
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
class NonVegItem extends FoodItem implements Discountable {

    public NonVegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    @Override
    public double calculateTotalPrice() {
        double base = getPrice() * getQuantity();
        return base + (base * 0.05); // 5% extra charge
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

// Main class
public class OnlineFood {

    // Polymorphic method
    public static void processOrder(FoodItem item) {
        item.getItemDetails();

        double total = item.calculateTotalPrice();
        double discount = 0;

        if (item instanceof Discountable) {
            Discountable d = (Discountable) item;
            discount = d.applyDiscount();
            System.out.println(d.getDiscountDetails());
        }

        double finalPrice = total - discount;

        System.out.println("Total Price: " + total);
        System.out.println("Discount: " + discount);
        System.out.println("Final Price: " + finalPrice);
        System.out.println("------------------------");
    }

    public static void main(String[] args) {

        FoodItem f1 = new VegItem("Paneer Butter Masala", 250, 2);
        FoodItem f2 = new NonVegItem("Chicken Biryani", 300, 2);

        FoodItem[] items = {f1, f2};

        // Polymorphism
        for (FoodItem item : items) {
            processOrder(item);
        }
    }
}
