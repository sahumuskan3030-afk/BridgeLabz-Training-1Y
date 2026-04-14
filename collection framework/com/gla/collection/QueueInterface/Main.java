package com.gla.collection.QueueInterface;

import java.util.Arrays;

class CircularBuffer {
    private int[] buffer;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    // Insert element
    public void insert(int value) {

        // If buffer is full → overwrite oldest
        if (size == capacity) {
            buffer[rear] = value;
            rear = (rear + 1) % capacity;
            front = (front + 1) % capacity; // move oldest forward
        } else {
            buffer[rear] = value;
            rear = (rear + 1) % capacity;
            size++;
        }
    }

    // Display buffer contents in order
    public void display() {
        System.out.print("Buffer: [");

        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(buffer[index]);

            if (i < size - 1) System.out.print(", ");
        }

        System.out.println("]");
    }
}
public class Main {
    public static void main(String[] args) {

        CircularBuffer cb = new CircularBuffer(3);

        cb.insert(1);
        cb.insert(2);
        cb.insert(3);

        cb.display(); // [1, 2, 3]

        cb.insert(4); // overwrites 1

        cb.display(); // [2, 3, 4]
    }
}
