package com.gla.ExceptionHandling;

public class ExceptionPropagationExample {

    // Method 1: Throws ArithmeticException
    public static void method1() {
        int result = 10 / 0; // This will cause ArithmeticException
    }

    // Method 2: Calls method1()
    public static void method2() {
        method1(); // Exception propagates to this method
    }

    public static void main(String[] args) {
        try {
            // Calling method2()
            method2();

        } catch (ArithmeticException e) {
            // Handling exception in main
            System.out.println("Handled exception in main");
        }
    }
}
