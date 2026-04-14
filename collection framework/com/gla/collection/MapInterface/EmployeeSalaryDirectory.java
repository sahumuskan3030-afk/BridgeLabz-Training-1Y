package com.gla.collection.MapInterface;

import java.util.*;

public class EmployeeSalaryDirectory {

    public static void main(String[] args) {

        // Map: Employee -> Salary
        Map<String, Double> salaries = new HashMap<>();

        // 1. Add at least 6 employees
        salaries.put("Aman", 50000.0);
        salaries.put("Ravi", 65000.0);
        salaries.put("Zara", 72000.0);
        salaries.put("Meena", 60000.0);
        salaries.put("Kiran", 80000.0);
        salaries.put("Neha", 75000.0);

        System.out.println("Initial Salaries:");
        printSalaries(salaries);

        // 2. Give raises
        giveRaise(salaries, "Aman", 10);   // 10% raise
        giveRaise(salaries, "Zara", 5);    // 5% raise
        giveRaise(salaries, "Kiran", 15);  // 15% raise
        giveRaise(salaries, "Unknown", 10); // not found case

        System.out.println("\nAfter Raises:");
        printSalaries(salaries);

        // 3. Average salary
        double avg = calculateAverage(salaries);
        System.out.println("\nAverage Salary: " + avg);

        // 4. Highest-paid employee(s)
        printHighestPaid(salaries);
    }

    // Add raise to employee salary
    public static void giveRaise(Map<String, Double> salaries, String name, double percent) {
        if (!salaries.containsKey(name)) {
            System.out.println("Employee not found: " + name);
            return;
        }

        double currentSalary = salaries.get(name);
        double newSalary = currentSalary + (currentSalary * percent / 100);

        salaries.put(name, newSalary);

        System.out.println(name + " got a " + percent + "% raise.");
    }

    // Calculate average salary
    public static double calculateAverage(Map<String, Double> salaries) {
        double sum = 0;

        for (double salary : salaries.values()) {
            sum += salary;
        }

        return sum / salaries.size();
    }

    // Find and print highest-paid employee(s)
    public static void printHighestPaid(Map<String, Double> salaries) {

        double maxSalary = Collections.max(salaries.values());

        System.out.println("\nHighest Paid Employee(s):");
        for (Map.Entry<String, Double> entry : salaries.entrySet()) {
            if (entry.getValue() == maxSalary) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }
    }

    // Print all employees
    public static void printSalaries(Map<String, Double> salaries) {
        for (Map.Entry<String, Double> entry : salaries.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
