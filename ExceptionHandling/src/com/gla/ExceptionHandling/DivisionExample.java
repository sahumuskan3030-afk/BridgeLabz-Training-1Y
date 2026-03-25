package com.gla.ExceptionHandling;

import java.util.Scanner;
import java.util.InputMismatchException;

public class DivisionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Taking user input
            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();

            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();

            // Performing division
            int result = num1 / num2;

            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            // Handles division by zero
            System.out.println("Error: Cannot divide by zero.");

        } catch (InputMismatchException e) {
            // Handles non-numeric input
            System.out.println("Error: Please enter valid numeric values.");

        } finally {
            scanner.close();
        }
    }
}
