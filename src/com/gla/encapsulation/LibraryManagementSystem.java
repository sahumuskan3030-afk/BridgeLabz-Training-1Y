package com.gla.encapsulation;

import java.util.*;

public class LibraryManagementSystem {

    // Interface
    interface Reservable {
        void reserveItem(String borrowerName);
        boolean checkAvailability();
    }

    // Abstract Class
    static abstract class LibraryItem {
        private int itemId;
        private String title;
        private String author;

        public LibraryItem(int itemId, String title, String author) {
            this.itemId = itemId;
            this.title = title;
            this.author = author;
        }

        // Abstract method
        public abstract int getLoanDuration();

        // Concrete method
        public void getItemDetails() {
            System.out.println("Item ID: " + itemId);
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
        }

        // Encapsulation (Getters only)
        public int getItemId() {
            return itemId;
        }

        public String getTitle() {
            return title;
        }
    }

    // Book Class
    static class Book extends LibraryItem implements Reservable {
        private boolean isAvailable = true;
        private String borrowerName; // Encapsulated

        public Book(int id, String title, String author) {
            super(id, title, author);
        }

        @Override
        public int getLoanDuration() {
            return 14; // 14 days
        }

        @Override
        public void reserveItem(String borrowerName) {
            if (isAvailable) {
                this.borrowerName = borrowerName;
                isAvailable = false;
                System.out.println("Book reserved by " + borrowerName);
            } else {
                System.out.println("Book not available");
            }
        }

        @Override
        public boolean checkAvailability() {
            return isAvailable;
        }
    }

    // Magazine Class
    static class Magazine extends LibraryItem implements Reservable {
        private boolean isAvailable = true;
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
            if (isAvailable) {
                this.borrowerName = borrowerName;
                isAvailable = false;
                System.out.println("Magazine reserved by " + borrowerName);
            } else {
                System.out.println("Magazine not available");
            }
        }

        @Override
        public boolean checkAvailability() {
            return isAvailable;
        }
    }

    // DVD Class
    static class DVD extends LibraryItem implements Reservable {
        private boolean isAvailable = true;
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
            if (isAvailable) {
                this.borrowerName = borrowerName;
                isAvailable = false;
                System.out.println("DVD reserved by " + borrowerName);
            } else {
                System.out.println("DVD not available");
            }
        }

        @Override
        public boolean checkAvailability() {
            return isAvailable;
        }
    }

    // Polymorphism Method
    public static void processItems(List<LibraryItem> items) {
        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            if (item instanceof Reservable) {
                Reservable res = (Reservable) item;

                if (res.checkAvailability()) {
                    res.reserveItem("User1");
                } else {
                    System.out.println("Already Reserved");
                }
            }

            System.out.println("---------------------------");
        }
    }

    // Main Method
    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();

        items.add(new Book(1, "Java Programming", "James Gosling"));
        items.add(new Magazine(2, "Tech Today", "Editor"));
        items.add(new DVD(3, "Inception", "Christopher Nolan"));

        processItems(items);
    }
}
