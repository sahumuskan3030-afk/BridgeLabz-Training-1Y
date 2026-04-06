package com.gla.Wrapper;

public class WrapperConversion {
    public static void main(String[] args) {
        // Given Double object
        Double obj = 45.67;

        // Convert to primitive double (auto-unboxing)
        double d = obj;

        // Convert to int using casting
        int i = (int) d;

        // Print values
        System.out.println("Double object value: " + obj);
        System.out.println("Primitive double value: " + d);
        System.out.println("Primitive int value: " + i);
    }
}
