package com.gla.ExceptionHandling;

import java.util.Scanner;

public class MultipleCatchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Declare array (you can change to null to test NullPointerException)
            int[] arr = {10, 20, 30, 40, 50};

            // Uncomment below line to test NullPointerException
            // arr = null;

            // Take index input
            System.out.print("Enter index: ");
            int index = scanner.nextInt();

            // Access array element
            int value = arr[index];

            // Print result
            System.out.println("Value at index " + index + ": " + value);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");

        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");

        } finally {
            scanner.close();
        }
    }
}
