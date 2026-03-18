package com.gla.instance.level2;



    class Book {

        public String ISBN;
        protected String title;
        private String author;

        public Book(String ISBN, String title, String author) {
            this.ISBN = ISBN;
            this.title = title;
            this.author = author;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void displayBookDetails() {
            System.out.println("ISBN: " + ISBN);
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("---------------------");
        }
    }

    class EBook extends Book {

        private double fileSizeMB;

        public EBook(String ISBN, String title, String author, double fileSizeMB) {
            super(ISBN, title, author);
            this.fileSizeMB = fileSizeMB;
        }

        public void displayEBookDetails() {
            System.out.println("ISBN: " + ISBN);
            System.out.println("Title: " + title);
            System.out.println("File Size: " + fileSizeMB + " MB");
            System.out.println("Author: " + getAuthor());
            System.out.println("---------------------");
        }

        public static void main(String[] args) {
            EBook ebook = new EBook("978-0134685991", "Effective Java", "Joshua Bloch", 5.5);
            ebook.displayEBookDetails();
            ebook.setAuthor("J. Bloch");
            System.out.println("Updated Author: " + ebook.getAuthor());
        }
    }

