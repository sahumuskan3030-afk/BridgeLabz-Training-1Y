package com.gla.generics;

import java.util.*;

public class Sum {

    // Method to sum numbers
    public static double sumNumbers(List<? extends Number> list) {
        double sum = 0.0;

        for (Number num : list) {
            sum += num.doubleValue();
        }

        return sum;
    }

    public static void main(String[] args) {

        // List of Integers
        List<Integer> intList = Arrays.asList(10, 20, 30);
        System.out.println("Sum of Integers: " + sumNumbers(intList));

        // List of Doubles
        List<Double> doubleList = Arrays.asList(5.5, 2.5, 1.0);
        System.out.println("Sum of Doubles: " + sumNumbers(doubleList));
    }
}
