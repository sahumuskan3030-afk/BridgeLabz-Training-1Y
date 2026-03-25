package com.gla.practiceproblem1;

import java.time.LocalDate;
import java.util.Scanner;

public class DateArithmeticExample {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // User se date input lo (format: YYYY-MM-DD)
        System.out.print("Enter a date (YYYY-MM-DD): ");
        String input = sc.nextLine();

        LocalDate date = LocalDate.parse(input);

        // Add operations
        LocalDate updatedDate = date
                .plusDays(7)
                .plusMonths(1)
                .plusYears(2);

        // Subtract 3 weeks
        updatedDate = updatedDate.minusWeeks(3);

        // Output
        System.out.println("Final Date: " + updatedDate);
    }
}
