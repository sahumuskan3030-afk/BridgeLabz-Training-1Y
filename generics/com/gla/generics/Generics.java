package com.gla.generics;

public class Generics {
    // Generic method to compare two values
    public static <T> boolean isEqual(T a, T b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.equals(b);
    }

    public static void main(String[] args) {

        // Test with Integer
        System.out.println(isEqual(10, 10));   // true

        // Test with String
        System.out.println(isEqual("Hello", "Hello")); // true

        // Test with Double
        System.out.println(isEqual(5.5, 6.5)); // false
    }
}
