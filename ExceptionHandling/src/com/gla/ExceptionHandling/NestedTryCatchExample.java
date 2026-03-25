package com.gla.ExceptionHandling;

import java.util.Scanner;

public class NestedTryCatchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample array
        int[] arr = {10, 20, 30, 40, 50};

        try {
            // Take index input
            System.out.print("Enter index: ");
            int index = scanner.nextInt();

            try {
                // Access array element
                int value = arr[index];

                // Take divisor input
                System.out.print("Enter divisor: ");
                int divisor = scanner.nextInt();

                // Perform division
                int result = value / divisor;

                System.out.println("Result: " + result);

            } catch (ArithmeticException e) {
                // Handles division by zero
                System.out.println("Cannot divide by zero!");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            // Handles invalid index
            System.out.println("Invalid array index!");
        } finally {
            scanner.close();
        }
    }
}
