package com.gla.collection.Task;
import java.util.*;
class Book {
    int bookId;
    String title;
    String author;
    boolean isIssued;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    @Override
    public String toString() {
        return "Book{id=" + bookId + ", title='" + title + "', author='" + author + "'}";
    }
}


public class LibrarySystem {

    public static void main(String[] args) {

        // 1. Total books in library
        List<Book> books = new ArrayList<>();

        // 2. Unique members
        Set<String> members = new HashSet<>();

        // 3. Issue queue (waiting list)
        Queue<Book> issueQueue = new LinkedList<>();

        // 4. Recently returned books
        Stack<Book> returnedStack = new Stack<>();

        // ----------------------------
        // Add books
        // ----------------------------
        addBook(books, new Book(1, "Java Basics", "James"));
        addBook(books, new Book(2, "DSA", "CLRS"));
        addBook(books, new Book(3, "Operating Systems", "Galvin"));

        // ----------------------------
        // Register members
        // ----------------------------
        registerMember(members, "M1");
        registerMember(members, "M2");
        registerMember(members, "M1"); // duplicate

        // ----------------------------
        // Borrow books
        // ----------------------------
        issueBook(books, issueQueue, "Java Basics");
        issueBook(books, issueQueue, "DSA");

        System.out.println("\nIssuing Books...\n");

        while (!issueQueue.isEmpty()) {
            Book book = issueQueue.poll();
            book.isIssued = true;
            System.out.println("Issued: " + book);
        }

        // ----------------------------
        // Return books
        // ----------------------------
        returnBook(books, returnedStack, "Java Basics");

        // ----------------------------
        // Re-issue recently returned book
        // ----------------------------
        System.out.println("\nRe-issuing last returned book...");
        if (!returnedStack.isEmpty()) {
            Book book = returnedStack.pop();
            book.isIssued = true;
            System.out.println("Re-issued: " + book);
        }

        // ----------------------------
        // Final status
        // ----------------------------
        System.out.println("\nLibrary Books Status:");
        for (Book b : books) {
            System.out.println(b + " | Issued: " + b.isIssued);
        }
    }

    // Add book
    public static void addBook(List<Book> books, Book book) {
        books.add(book);
        System.out.println("Added book: " + book);
    }

    // Register member
    public static void registerMember(Set<String> members, String id) {
        if (members.add(id)) {
            System.out.println("Member registered: " + id);
        } else {
            System.out.println("Duplicate member rejected: " + id);
        }
    }

    // Issue book (enqueue request)
    public static void issueBook(List<Book> books, Queue<Book> queue, String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title) && !b.isIssued) {
                queue.offer(b);
                return;
            }
        }
        System.out.println("Book not available: " + title);
    }

    // Return book
    public static void returnBook(List<Book> books, Stack<Book> stack, String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                b.isIssued = false;
                stack.push(b);
                System.out.println("Returned: " + b);
                return;
            }
        }
    }
}