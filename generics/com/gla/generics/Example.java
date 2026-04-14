package com.gla.generics;

// Generic Pair class
class Pair<T, U> {
    private T first;
    private U second;

    // Constructor
    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    // Get first value
    public T getFirst() {
        return first;
    }

    // Get second value
    public U getSecond() {
        return second;
    }
}

// Test class
public class Example {
    public static void main(String[] args) {

        // Example usage
        Pair<String, Integer> student = new Pair<>("Amol", 20);

        System.out.println("Name: " + student.getFirst());
        System.out.println("Age: " + student.getSecond());
    }
}
