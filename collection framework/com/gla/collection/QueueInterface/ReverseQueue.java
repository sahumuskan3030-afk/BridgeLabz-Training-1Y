package com.gla.collection.QueueInterface;

import java.util.*;

public class ReverseQueue {

    public static <T> void reverseQueue(Queue<T> queue) {

        // Base case
        if (queue.isEmpty()) {
            return;
        }

        // Step 1: remove front
        T front = queue.remove();

        // Step 2: reverse remaining queue
        reverseQueue(queue);

        // Step 3: add removed element at rear
        queue.add(front);
    }

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Original Queue: " + queue);

        reverseQueue(queue);

        System.out.println("Reversed Queue: " + queue);
    }
}
