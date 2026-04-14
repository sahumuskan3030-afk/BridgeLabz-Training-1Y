package com.gla.collection.MapInterface;

import java.util.*;

public class ExamResults {

    public static void main(String[] args) {

        // Outer Map: Subject -> (Student -> Marks)
        Map<String, Map<String, Integer>> results = new HashMap<>();

        // 1. Add data for multiple subjects

        Map<String, Integer> math = new HashMap<>();
        math.put("Aman", 85);
        math.put("Ravi", 92);
        math.put("Zara", 78);
        math.put("Meena", 95);

        Map<String, Integer> science = new HashMap<>();
        science.put("Aman", 88);
        science.put("Ravi", 75);
        science.put("Zara", 91);
        science.put("Meena", 89);

        Map<String, Integer> english = new HashMap<>();
        english.put("Aman", 80);
        english.put("Ravi", 84);
        english.put("Zara", 87);
        english.put("Meena", 82);

        results.put("Math", math);
        results.put("Science", science);
        results.put("English", english);

        // 2. Print all results + find toppers
        System.out.println("Subject-wise Results and Toppers:\n");

        for (Map.Entry<String, Map<String, Integer>> subjectEntry : results.entrySet()) {

            String subject = subjectEntry.getKey();
            Map<String, Integer> marksMap = subjectEntry.getValue();

            System.out.println("Subject: " + subject);

            // Print all student marks
            for (Map.Entry<String, Integer> entry : marksMap.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }

            // Find topper
            String topper = null;
            int maxMarks = -1;

            for (Map.Entry<String, Integer> entry : marksMap.entrySet()) {
                if (entry.getValue() > maxMarks) {
                    maxMarks = entry.getValue();
                    topper = entry.getKey();
                }
            }

            System.out.println("🏆 Topper: " + topper + " (" + maxMarks + " marks)");
            System.out.println("------------------------------------");
        }
    }
}
