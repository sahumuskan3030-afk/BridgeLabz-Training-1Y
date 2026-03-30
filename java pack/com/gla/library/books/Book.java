package com.gla.library.books;




    public class Book {
        private int bookId;
        private String title;
        private String author;
        private boolean isIssued;

        public Book(int bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
            this.isIssued = false;
        }

        public void displayBook() {
            System.out.println("Book ID: " + bookId);
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("Issued: " + isIssued);
        }

        public boolean isIssued() {
            return isIssued;
        }

        public void setIssued(boolean status) {
            this.isIssued = status;
        }

        public int getBookId() {
            return bookId;
        }
    }

