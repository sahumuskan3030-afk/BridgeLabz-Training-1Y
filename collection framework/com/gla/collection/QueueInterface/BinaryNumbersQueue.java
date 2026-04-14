package com.gla.collection.QueueInterface;

import java.util.*;

public class BinaryNumbersQueue {

    public static List<String> generateBinaryNumbers(int n) {

        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        // start with "1"
        queue.add("1");

        for (int i = 0; i < n; i++) {

            // get front
            String current = queue.remove();

            // add to result
            result.add(current);

            // generate next binary numbers
            queue.add(current + "0");
            queue.add(current + "1");
        }

        return result;
    }

    public static void main(String[] args) {

        int n = 5;

        System.out.println("N = " + n);
        System.out.println("Binary Numbers: " + generateBinaryNumbers(n));
    }
}
