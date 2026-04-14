package com.gla.collection.MapInterface;

import java.util.*;

public class EmployeeDepartmentMapping {

    public static void main(String[] args) {

        // Map: Employee ID -> Department
        Map<Integer, String> employees = new HashMap<>();

        // 1. Add employees
        employees.put(101, "HR");
        employees.put(102, "IT");
        employees.put(103, "Finance");
        employees.put(104, "IT");
        employees.put(105, "HR");
        employees.put(106, "Marketing");

        System.out.println("Initial Employee Data:");
        printEmployees(employees);

        // 2. Change department of an employee (update)
        updateDepartment(employees, 103, "IT");
        updateDepartment(employees, 999, "HR"); // not found case

        System.out.println("\nAfter Department Update:");
        printEmployees(employees);

        // 3. Reverse lookup: employees in a given department
        System.out.println("\nEmployees in IT Department:");
        findByDepartment(employees, "IT");

        // 4. Total employees per department
        System.out.println("\nEmployee Count Per Department:");
        countByDepartment(employees);
    }

    // Print all employees
    public static void printEmployees(Map<Integer, String> employees) {
        for (Map.Entry<Integer, String> entry : employees.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Update department
    public static void updateDepartment(Map<Integer, String> employees, int id, String newDept) {
        if (employees.containsKey(id)) {
            employees.put(id, newDept);
            System.out.println("Employee " + id + " moved to " + newDept);
        } else {
            System.out.println("Employee ID not found: " + id);
        }
    }

    // Reverse lookup: find employees by department
    public static void findByDepartment(Map<Integer, String> employees, String dept) {
        boolean found = false;

        for (Map.Entry<Integer, String> entry : employees.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(dept)) {
                System.out.println("Employee ID: " + entry.getKey());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No employees found in " + dept);
        }
    }

    // Count employees per department
    public static void countByDepartment(Map<Integer, String> employees) {
        Map<String, Integer> countMap = new HashMap<>();

        for (String dept : employees.values()) {
            countMap.put(dept, countMap.getOrDefault(dept, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
