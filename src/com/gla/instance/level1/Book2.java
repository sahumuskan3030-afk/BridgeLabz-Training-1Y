package com.gla.instance.level1;



    // Book.java
    class Book2 {
        // Attributes
        String title;
        String author;
        double price;

        // Default constructor
        public Book2() {
            this.title = "Unknown Title";
            this.author = "Unknown Author";
            this.price = 0.0;
        }

        // Parameterized constructor
        public Book2(String title, String author, double price) {
            this.title = title;
            this.author = author;
            this.price = price;
        }

        // Method to display book details
        public void displayDetails() {
            System.out.println("Book Details:");
            System.out.println("Title : " + title);
            System.out.println("Author: " + author);
            System.out.println("Price : $" + price);
            System.out.println("----------------------");
        }

        // Main method to test the Book class
        public static void main(String[] args) {
            // Using default constructor
            Book2 defaultBook = new Book2();
            defaultBook.displayDetails();

            // Using parameterized constructor
            Book2 customBook = new Book2("The Hobbit", "J.R.R. Tolkien", 19.99);
            customBook.displayDetails();
        }
    }

