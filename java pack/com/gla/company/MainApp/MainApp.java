package com.gla.company.MainApp;



import com.gla.company.hr.Employee.Employee;
import com.gla.company.payroll.Payroll;

    public class MainApp {

        public static void main(String[] args) {

            // Create Employee object
            Employee emp = new Employee(101, "Rahul", "IT", 50000);

            // Display original details
            System.out.println("Before Bonus:");
            System.out.println("ID: " + emp.getId());
            System.out.println("Name: " + emp.getName());
            System.out.println("Department: " + emp.getDepartment());
            System.out.println("Salary: " + emp.getSalary());

            // Apply bonus
            Payroll payroll = new Payroll();
            payroll.calculateBonus(emp);

            // Display updated details
            System.out.println("\nAfter Bonus:");
            System.out.println("Salary: " + emp.getSalary());
        }
    }

