package com.gla.collection.ListInterface;

import java.util.*;

public class NthFromEnd {

    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {

        if (n <= 0) {
            throw new IllegalArgumentException("N must be greater than 0");
        }

        Iterator<T> fast = list.iterator();
        Iterator<T> slow = list.iterator();

        // Move fast pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (!fast.hasNext()) {
                throw new IllegalArgumentException("N is larger than list size");
            }
            fast.next();
        }

        // Move both pointers until fast reaches end
        T result = null;

        while (fast.hasNext()) {
            fast.next();
            result = slow.next();
        }

        return result;
    }

    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        int n = 2;

        System.out.println("Input: " + list);
        System.out.println("N = " + n);

        String result = findNthFromEnd(list, n);

        System.out.println("Output: " + result);
    }
}
