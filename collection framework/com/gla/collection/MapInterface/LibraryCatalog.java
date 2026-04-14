package com.gla.collection.MapInterface;

import java.util.*;

public class LibraryCatalog {

    public static void main(String[] args) {

        // Map: ISBN -> Book Title
        Map<String, String> library = new HashMap<>();

        // 1. Add books
        library.put("978-1234567890", "Java Basics");
        library.put("978-1111111111", "Data Structures");
        library.put("978-2222222222", "Operating Systems");
        library.put("978-3333333333", "Database Management");

        System.out.println("Initial Library Catalog:");
        printSorted(library);

        // 2. Search by ISBN
        System.out.println("\nSearch by ISBN:");
        searchByISBN(library, "978-1111111111");
        searchByISBN(library, "978-9999999999");

        // 3. Remove a book
        library.remove("978-2222222222");

        System.out.println("\nAfter Removing a Book:");
        printSorted(library);

        // 4. Search by title
        System.out.println("\nSearch by Title:");
        searchByTitle(library, "Java Basics");
        searchByTitle(library, "Artificial Intelligence");
    }

    // Print all books sorted by ISBN
    public static void printSorted(Map<String, String> library) {
        Map<String, String> sorted = new TreeMap<>(library);

        for (Map.Entry<String, String> entry : sorted.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Search book by ISBN
    public static void searchByISBN(Map<String, String> library, String isbn) {
        if (library.containsKey(isbn)) {
            System.out.println("Found: " + library.get(isbn));
        } else {
            System.out.println("Book not found for ISBN: " + isbn);
        }
    }

    // Search book by title (iterate through map)
    public static void searchByTitle(Map<String, String> library, String title) {
        boolean found = false;

        for (Map.Entry<String, String> entry : library.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(title)) {
                System.out.println("Found: ISBN = " + entry.getKey());
                found = true;
            }
        }

        if (!found) {
            System.out.println("Book not found with title: " + title);
        }
    }
}
