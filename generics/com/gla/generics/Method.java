package com.gla.generics;

public class Method {
    // Generic method with bounded type (must implement Comparable)
    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;

        if (y.compareTo(max) > 0) {
            max = y;
        }

        if (z.compareTo(max) > 0) {
            max = z;
        }

        return max;
    }

    public static void main(String[] args) {

        // Test with Integer
        System.out.println("Max Integer: " + maximum(10, 20, 15));

        // Test with Double
        System.out.println("Max Double: " + maximum(5.5, 2.3, 9.8));

        // Test with String (lexicographical comparison)
        System.out.println("Max String: " + maximum("Apple", "Banana", "Mango"));
    }
}
