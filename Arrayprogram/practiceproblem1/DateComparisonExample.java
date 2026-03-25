package com.gla.practiceproblem1;

import java.time.LocalDate;
import java.util.Scanner;

public class DateComparisonExample {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input dates (format: YYYY-MM-DD)
        System.out.print("Enter first date (YYYY-MM-DD): ");
        LocalDate date1 = LocalDate.parse(sc.nextLine());

        System.out.print("Enter second date (YYYY-MM-DD): ");
        LocalDate date2 = LocalDate.parse(sc.nextLine());

        // Comparison
        if (date1.isBefore(date2)) {
            System.out.println("First date is BEFORE second date");
        } else if (date1.isAfter(date2)) {
            System.out.println("First date is AFTER second date");
        } else if (date1.isEqual(date2)) {
            System.out.println("Both dates are SAME");
        }
    }
}
