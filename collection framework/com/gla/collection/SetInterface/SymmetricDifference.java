package com.gla.collection.SetInterface;

import java.util.*;

public class SymmetricDifference {

    public static <T> Set<T> symmetricDifference(Set<T> set1, Set<T> set2) {

        Set<T> result = new HashSet<>();

        // Add elements from set1 not in set2
        for (T item : set1) {
            if (!set2.contains(item)) {
                result.add(item);
            }
        }

        // Add elements from set2 not in set1
        for (T item : set2) {
            if (!set1.contains(item)) {
                result.add(item);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);

        Set<Integer> result = symmetricDifference(set1, set2);

        System.out.println("Symmetric Difference: " + result);
    }
}
