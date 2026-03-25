package com.gla.practiceproblem2;

import java.util.Scanner;

public class FactorialRecursion {

    // Function to take input
    public static int takeInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        return sc.nextInt();
    }

    // Recursive function to calculate factorial
    public static long factorial(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    // Function to display result
    public static void displayResult(int n, long result) {
        System.out.println("Factorial of " + n + " is: " + result);
    }

    public static void main(String[] args) {

        int number = takeInput();
        long result = factorial(number);

        displayResult(number, result);
    }
}
