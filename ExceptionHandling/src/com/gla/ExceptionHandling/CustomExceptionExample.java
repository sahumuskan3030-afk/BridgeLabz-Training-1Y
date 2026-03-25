package com.gla.ExceptionHandling;

import java.util.Scanner;

// Step 1: Create custom exception
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomExceptionExample {

    // Step 2: Method to validate age
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above");
        } else {
            System.out.println("Access granted!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Step 3: Take user input
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();

            // Step 4: Call validation method
            validateAge(age);

        } catch (InvalidAgeException e) {
            // Step 5: Handle custom exception
            System.out.println(e.getMessage());
        } catch (Exception e) {
            // Handle invalid input (optional)
            System.out.println("Invalid input. Please enter a number.");
        } finally {
            scanner.close();
        }
    }
}
