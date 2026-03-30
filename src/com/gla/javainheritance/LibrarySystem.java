package com.gla.javainheritance;

// Interface
interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

// Abstract class
abstract class LibraryItem {
    private int itemId;
    private String title;
    private String author;
    private boolean isAvailable = true;

    // Constructor
    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Encapsulation: Getters
    public int getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    protected boolean isAvailable() {
        return isAvailable;
    }

    protected void setAvailability(boolean status) {
        this.isAvailable = status;
    }

    // Abstract method
    public abstract int getLoanDuration();

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Available: " + isAvailable);
    }
}

// Book class
class Book extends LibraryItem implements Reservable {
    private String borrowerName; // encapsulated

    public Book(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14; // 14 days
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable()) {
            this.borrowerName = borrowerName;
            setAvailability(false);
            System.out.println("Book reserved by " + borrowerName);
        } else {
            System.out.println("Book not available");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

// Magazine class
class Magazine extends LibraryItem implements Reservable {
    private String borrowerName;

    public Magazine(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // 7 days
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable()) {
            this.borrowerName = borrowerName;
            setAvailability(false);
            System.out.println("Magazine reserved by " + borrowerName);
        } else {
            System.out.println("Magazine not available");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

// DVD class
class DVD extends LibraryItem implements Reservable {
    private String borrowerName;

    public DVD(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 5; // 5 days
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable()) {
            this.borrowerName = borrowerName;
            setAvailability(false);
            System.out.println("DVD reserved by " + borrowerName);
        } else {
            System.out.println("DVD not available");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

// Main class
public class LibrarySystem {

    public static void processItem(LibraryItem item) {
        item.getItemDetails();
        System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

        if (item instanceof Reservable) {
            Reservable r = (Reservable) item;
            System.out.println("Available: " + r.checkAvailability());
        }

        System.out.println("------------------------");
    }

    public static void main(String[] args) {

        LibraryItem b = new Book(1, "Java Basics", "James Gosling");
        LibraryItem m = new Magazine(2, "Tech Today", "Editor");
        LibraryItem d = new DVD(3, "Inception", "Christopher Nolan");

        LibraryItem[] items = {b, m, d};

        // Reserve some items
        ((Reservable) b).reserveItem("Rahul");
        ((Reservable) d).reserveItem("Anita");

        // Polymorphism
        for (LibraryItem item : items) {
            processItem(item);
        }
    }
}
