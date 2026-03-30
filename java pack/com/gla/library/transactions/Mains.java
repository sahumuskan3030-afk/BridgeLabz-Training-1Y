package com.gla.library.transactions;


    import com.gla.library.books.Book;
import com.gla.library.members.Member;
import com.gla.library.transactions.Transaction;

    public class Mains {
        public static void main(String[] args) {

            // 1. Adding a new book
            Book book1 = new Book(101, "Java Programming", "James Gosling");
            System.out.println("New Book Added:");
            book1.displayBook();

            System.out.println("-------------------");

            // 2. Registering a new member
            Member member1 = new Member(1, "Rahul");
            System.out.println("New Member Registered:");
            member1.displayMember();

            System.out.println("-------------------");

            // 3. Issuing a book
            Transaction transaction = new Transaction();
            transaction.issueBook(book1, member1);
        }
    }

