package com.gla.collection.MapInterface;

import java.util.*;

public class AttendanceTracker {

    public static void main(String[] args) {

        // 1. Initialize students with 0 attendance
        Map<String, Integer> attendance = new HashMap<>();

        String[] students = {"Aman", "Ravi", "Zara", "Meena", "Kiran"};

        for (String student : students) {
            attendance.put(student, 0);
        }

        // 2. Simulate attendance for 15 days
        Random random = new Random();

        for (int day = 1; day <= 15; day++) {

            System.out.println("Day " + day + " present students:");

            for (String student : students) {
                // 80% chance student is present
                boolean isPresent = random.nextInt(100) < 80;

                if (isPresent) {
                    attendance.put(student, attendance.get(student) + 1);
                    System.out.print(student + " ");
                }
            }

            System.out.println("\n");
        }

        // 3. Print final attendance
        System.out.println("Final Attendance:");
        for (Map.Entry<String, Integer> entry : attendance.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " days");
        }

        // 4. Students below threshold
        int threshold = 10;

        System.out.println("\nStudents with attendance fewer than " + threshold + " days:");
        for (Map.Entry<String, Integer> entry : attendance.entrySet()) {
            if (entry.getValue() < threshold) {
                System.out.println(entry.getKey() + " -> " + entry.getValue() + " days");
            }
        }
    }
}
