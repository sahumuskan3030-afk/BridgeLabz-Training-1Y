package com.gla.collection.MapInterface;

import java.util.*;

public class StudentGradeTracker {
    public static void main(String[] args) {

        // 1. Create a Map to store student names and grades
        Map<String, Double> grades = new HashMap<>();

        // 2. Adding several students and their grades
        grades.put("Aman", 85.5);
        grades.put("Zara", 92.0);
        grades.put("Ravi", 76.0);
        grades.put("Meena", 88.5);

        System.out.println("Initial Grades:");
        printSorted(grades);

        // 3. Updating a student's grade (re-take test)
        grades.put("Ravi", 82.0); // updated value replaces old value

        System.out.println("\nAfter Updating Ravi's Grade:");
        printSorted(grades);

        // 4. Removing a student who dropped out
        grades.remove("Aman");

        System.out.println("\nAfter Removing Aman:");
        printSorted(grades);
    }

    // 5. Method to print map sorted by student names (keys)
    public static void printSorted(Map<String, Double> grades) {
        // TreeMap automatically sorts by keys (alphabetical order)
        Map<String, Double> sorted = new TreeMap<>(grades);

        for (Map.Entry<String, Double> entry : sorted.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
