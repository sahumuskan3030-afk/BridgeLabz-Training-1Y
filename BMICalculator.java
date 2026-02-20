package com.gla.array.Level2;

import java.util.Scanner;

public class BMICalculator {

    // Method to calculate BMI and populate 3rd column
    public static void calculateBMI(double[][] data) {

        for (int i = 0; i < data.length; i++) {

            double weight = data[i][0];
            double heightCm = data[i][1];

            double heightMeter = heightCm / 100.0;

            double bmi = weight / (heightMeter * heightMeter);

            data[i][2] = bmi; // store BMI
        }
    }

    // Method to determine BMI Status
    public static String[] getBMIStatus(double[][] data) {

        String[] status = new String[data.length];

        for (int i = 0; i < data.length; i++) {

            double bmi = data[i][2];

            if (bmi <= 18.4)
                status[i] = "Underweight";
            else if (bmi <= 24.9)
                status[i] = "Normal";
            else if (bmi <= 39.9)
                status[i] = "Overweight";
            else
                status[i] = "Obese";
        }

        return status;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[][] data = new double[10][3];
        // column 0 = weight
        // column 1 = height
        // column 2 = BMI

        for (int i = 0; i < 10; i++) {
            System.out.println("Person " + (i + 1));

            System.out.print("Enter weight (kg): ");
            data[i][0] = sc.nextDouble();

            System.out.print("Enter height (cm): ");
            data[i][1] = sc.nextDouble();
        }

        calculateBMI(data);

        String[] status = getBMIStatus(data);

        System.out.println("\n---- BMI REPORT ----");

        for (int i = 0; i < 10; i++) {
            System.out.printf("Person %d -> Weight: %.2f kg, Height: %.2f cm, BMI: %.2f, Status: %s\n",
                    (i + 1),
                    data[i][0],
                    data[i][1],
                    data[i][2],
                    status[i]);
        }

        sc.close();
    }
}
