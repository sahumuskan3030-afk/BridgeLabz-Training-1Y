package com.gla.practiceproblem1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormattingExample {
    public static void main(String[] args) {

        // Current date
        LocalDate today = LocalDate.now();

        // Different formats
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");

        // Display formatted dates
        System.out.println("Format 1 (dd/MM/yyyy): " + today.format(format1));
        System.out.println("Format 2 (yyyy-MM-dd): " + today.format(format2));
        System.out.println("Format 3 (EEE, MMM dd, yyyy): " + today.format(format3));
    }
}
