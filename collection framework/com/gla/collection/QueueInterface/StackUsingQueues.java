package com.gla.collection.QueueInterface;

import java.util.*;

class StackUsingQueues {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Push element onto stack
    public void push(int x) {

        // Step 1: move all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        // Step 2: add new element to q1
        q1.add(x);

        // Step 3: move everything back to q1
        while (!q2.isEmpty()) {
            q1.add(q2.remove());
        }
    }

    // Pop element from stack
    public int pop() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return q1.remove();
    }

    // Get top element
    public int top() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return q1.peek();
    }

    // Check if empty
    public boolean empty() {
        return q1.isEmpty();
    }
}
