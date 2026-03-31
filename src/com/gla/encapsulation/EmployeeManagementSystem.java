package com.gla.encapsulation;

import java.util.*;

public class EmployeeManagementSystem {

    // Interface
    interface Department {
        void assignDepartment(String deptName);
        String getDepartmentDetails();
    }

    // Abstract Class
    static abstract class Employee {
        private int employeeId;
        private String name;
        protected double baseSalary;

        public Employee(int employeeId, String name, double baseSalary) {
            this.employeeId = employeeId;
            this.name = name;
            this.baseSalary = baseSalary;
        }

        public abstract double calculateSalary();

        public void displayDetails() {
            System.out.println("Employee ID: " + employeeId);
            System.out.println("Name: " + name);
        }

        // Getters & Setters
        public int getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(int employeeId) {
            this.employeeId = employeeId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    // Full Time Employee
    static class FullTimeEmployee extends Employee implements Department {
        private String department;
        private double fixedSalary;

        public FullTimeEmployee(int id, String name, double fixedSalary) {
            super(id, name, fixedSalary);
            this.fixedSalary = fixedSalary;
        }

        @Override
        public double calculateSalary() {
            return fixedSalary;
        }

        @Override
        public void assignDepartment(String deptName) {
            this.department = deptName;
        }

        @Override
        public String getDepartmentDetails() {
            return "Department: " + department;
        }
    }

    // Part Time Employee
    static class PartTimeEmployee extends Employee implements Department {
        private String department;
        private int hoursWorked;
        private double hourlyRate;

        public PartTimeEmployee(int id, String name, int hoursWorked, double hourlyRate) {
            super(id, name, 0);
            this.hoursWorked = hoursWorked;
            this.hourlyRate = hourlyRate;
        }

        @Override
        public double calculateSalary() {
            return hoursWorked * hourlyRate;
        }

        @Override
        public void assignDepartment(String deptName) {
            this.department = deptName;
        }

        @Override
        public String getDepartmentDetails() {
            return "Department: " + department;
        }
    }

    // Main Method
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        FullTimeEmployee emp1 = new FullTimeEmployee(1, "Alice", 50000);
        emp1.assignDepartment("HR");

        PartTimeEmployee emp2 = new PartTimeEmployee(2, "Bob", 20, 500);
        emp2.assignDepartment("IT");

        employees.add(emp1);
        employees.add(emp2);

        // Polymorphism
        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println("Salary: " + emp.calculateSalary());

            if (emp instanceof Department) {
                Department dept = (Department) emp;
                System.out.println(dept.getDepartmentDetails());
            }

            System.out.println("----------------------");
        }
    }
}
