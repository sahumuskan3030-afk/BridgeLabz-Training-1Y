package com.gla.array.Level3;


import java.util.Scanner;

public class CalenderDisplay {

    // Array to store month names
    private static final String[] MONTH_NAMES = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    };

    // Array to store number of days in each month (non-leap year)
    private static final int[] DAYS_IN_MONTH = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
    };

    // Method to check if a year is a leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Method to get number of days in a month
    public static int getDaysInMonth(int month, int year) {
        if (month == 2) { // February
            return isLeapYear(year) ? 29 : 28;
        }
        return DAYS_IN_MONTH[month - 1];
    }

    // Method to get the name of the month
    public static String getMonthName(int month) {
        return MONTH_NAMES[month - 1];
    }

    // Method to get the first day of the month (0=Sunday, 1=Monday, ..., 6=Saturday)
    public static int getFirstDayOfMonth(int month, int year) {
        int y = year;
        int m = month;

        if (m < 3) {
            m += 12;
            y -= 1;
        }

        int k = y % 100;
        int j = y / 100;

        int day = (1 + (13 * (m + 1)) / 5 + k + (k / 4) + (j / 4) + 5 * j) % 7;

        // Zeller's Congruence returns 0=Saturday, 1=Sunday,..., 6=Friday
        // Adjust to make 0=Sunday, 1=Monday,...,6=Saturday
        int firstDay = (day + 6) % 7;
        return firstDay;
    }

    // Method to display the calendar
    public static void displayCalendar(int month, int year) {
        int firstDay = getFirstDayOfMonth(month, year);
        int totalDays = getDaysInMonth(month, year);

        System.out.println("\n     " + getMonthName(month) + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        // Indentation for the first day
        for (int i = 0; i < firstDay; i++) {
            System.out.print("    "); // 4 spaces
        }

        for (int day = 1; day <= totalDays; day++) {
            System.out.printf("%3d ", day);

            if ((day + firstDay) % 7 == 0) { // Move to next line after Saturday
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();

        System.out.print("Enter year: ");
        int year = scanner.nextInt();

        if (month < 1 || month > 12) {
            System.out.println("Invalid month input!");
        } else if (year < 1582) {
            System.out.println("Year must be >= 1582 for Gregorian calendar.");
        } else {
            displayCalendar(month, year);
        }

        scanner.close();
    }
}



