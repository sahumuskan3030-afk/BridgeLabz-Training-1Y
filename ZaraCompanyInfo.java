package com.gla.array.Level3;

import java.util.Random;

public class ZaraCompanyInfo {

    // Method to generate random salaries and years of service
    public static int[][] generateSalaryAndService(int numEmployees) {
        Random rand = new Random();
        int[][] data = new int[numEmployees][2]; // 0 -> salary, 1 -> years of service

        for (int i = 0; i < numEmployees; i++) {
            data[i][0] = rand.nextInt(90000) + 10000; // 5-digit salary: 10000–99999
            data[i][1] = rand.nextInt(20) + 1;        // years of service: 1–20
        }
        return data;
    }

    // Method to calculate new salary and bonus
    public static double[][] calculateNewSalaryAndBonus(int[][] data) {
        int numEmployees = data.length;
        double[][] newData = new double[numEmployees][2]; // 0 -> bonus, 1 -> new salary

        for (int i = 0; i < numEmployees; i++) {
            int salary = data[i][0];
            int years = data[i][1];
            double bonusPercentage = (years > 5) ? 0.05 : 0.02;
            double bonus = salary * bonusPercentage;
            double newSalary = salary + bonus;

            // Round to 2 decimal places
            bonus = Math.round(bonus * 100.0) / 100.0;
            newSalary = Math.round(newSalary * 100.0) / 100.0;

            newData[i][0] = bonus;
            newData[i][1] = newSalary;
        }
        return newData;
    }

    // Method to calculate totals
    public static void calculateAndDisplayTotals(int[][] oldData, double[][] newData) {
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;

        System.out.println("Employee\tOld Salary\tYears\tBonus\tNew Salary");
        System.out.println("-----------------------------------------------------------");

        for (int i = 0; i < oldData.length; i++) {
            int oldSalary = oldData[i][0];
            int years = oldData[i][1];
            double bonus = newData[i][0];
            double newSalary = newData[i][1];

            totalOldSalary += oldSalary;
            totalNewSalary += newSalary;
            totalBonus += bonus;

            System.out.printf("%d\t\t%d\t\t%d\t%.2f\t%.2f%n",
                    (i + 1), oldSalary, years, bonus, newSalary);
        }

        System.out.println("-----------------------------------------------------------");
        System.out.printf("Total\t\t%.2f\t\t\t%.2f\t%.2f%n", totalOldSalary, totalBonus, totalNewSalary);
    }

    public static void main(String[] args) {
        int numEmployees = 10;

        // Generate random salaries and years of service
        int[][] employeeData = generateSalaryAndService(numEmployees);

        // Calculate bonuses and new salaries
        double[][] updatedData = calculateNewSalaryAndBonus(employeeData);

        // Display individual and total data
        calculateAndDisplayTotals(employeeData, updatedData);
    }
}



