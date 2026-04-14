package com.gla.collection.MapInterface;

import java.util.*;

public class CourseRegistrationSystem {

    public static void main(String[] args) {

        // Map: Course Code -> Registered Students
        Map<String, Integer> courses = new HashMap<>();

        // 1. Add courses with initial registration counts
        courses.put("CS101", 45);
        courses.put("CS102", 52);
        courses.put("CS103", 3);
        courses.put("CS104", 25);
        courses.put("CS105", 60);

        System.out.println("Initial Course Data:");
        printCourses(courses);

        // 2. Simulate add/drop operations
        addStudent(courses, "CS101");
        addStudent(courses, "CS103");

        dropStudent(courses, "CS102");
        dropStudent(courses, "CS103"); // should not go negative

        System.out.println("\nAfter Updates:");
        printCourses(courses);

        // 3. Categorize courses
        System.out.println("\nNear Full Courses (>= 50):");
        for (Map.Entry<String, Integer> entry : courses.entrySet()) {
            if (entry.getValue() >= 50) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }

        System.out.println("\nUnder-Subscribed Courses (< 5):");
        for (Map.Entry<String, Integer> entry : courses.entrySet()) {
            if (entry.getValue() < 5) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }
    }

    // Add student (increment count)
    public static void addStudent(Map<String, Integer> courses, String course) {
        courses.put(course, courses.getOrDefault(course, 0) + 1);
        System.out.println("Student added to " + course);
    }

    // Drop student (decrement count safely)
    public static void dropStudent(Map<String, Integer> courses, String course) {
        if (!courses.containsKey(course)) {
            System.out.println(course + " not found.");
            return;
        }

        int count = courses.get(course);

        if (count > 0) {
            courses.put(course, count - 1);
            System.out.println("Student dropped from " + course);
        } else {
            System.out.println(course + " already has 0 students. Cannot drop.");
        }
    }

    // Print all courses
    public static void printCourses(Map<String, Integer> courses) {
        for (Map.Entry<String, Integer> entry : courses.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
