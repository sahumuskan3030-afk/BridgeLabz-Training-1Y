package com.gla.generics;

import java.util.*;

public class CopyList {

    // Method to copy elements
    public static void copyList(List<? super Number> dest, List<? extends Number> src) {
        for (Number num : src) {
            dest.add(num);
        }
    }

    public static void main(String[] args) {

        // Source list (Integer)
        List<Integer> srcList = Arrays.asList(10, 20, 30);

        // Destination list (Number)
        List<Number> destList = new ArrayList<>();

        copyList(destList, srcList);

        System.out.println("Destination List: " + destList);

        // Another example with Double
        List<Double> doubleList = Arrays.asList(5.5, 6.6);
        copyList(destList, doubleList);

        System.out.println("After adding doubles: " + destList);
    }
}
