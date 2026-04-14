package com.gla.collection.ListInterface;

import java.util.*;

public class RotateList {

    // Helper method to reverse part of list
    public static <T> void reverse(List<T> list, int start, int end) {
        while (start < end) {
            T temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);

            start++;
            end--;
        }
    }

    // Rotate list by k positions
    public static <T> void rotate(List<T> list, int k) {
        int n = list.size();

        // handle cases where k > size
        k = k % n;

        if (k == 0) return;

        // Step 1: reverse first k elements
        reverse(list, 0, k - 1);

        // Step 2: reverse remaining elements
        reverse(list, k, n - 1);

        // Step 3: reverse entire list
        reverse(list, 0, n - 1);
    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));

        int k = 2;

        System.out.println("Original List: " + list);

        rotate(list, k);

        System.out.println("Rotated by " + k + ": " + list);
    }
}
