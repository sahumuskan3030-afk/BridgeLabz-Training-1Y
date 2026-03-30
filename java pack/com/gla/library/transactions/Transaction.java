package com.gla.library.transactions;



import com.gla.library.books.Book;
import com.gla.library.members.Member;

    public class Transaction {

        public void issueBook(Book book, Member member) {
            if (!book.isIssued()) {
                book.setIssued(true);
                System.out.println("Book issued successfully!");
                System.out.println("Book ID: " + book.getBookId());
                System.out.println("Issued to Member ID: " + member.getMemberId());
            } else {
                System.out.println("Book is already issued!");
            }
        }

        public void returnBook(Book book) {
            if (book.isIssued()) {
                book.setIssued(false);
                System.out.println("Book returned successfully!");
            } else {
                System.out.println("Book was not issued.");
            }
        }
    }

