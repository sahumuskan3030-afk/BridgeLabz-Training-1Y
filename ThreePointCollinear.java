package com.gla.array.Level3;

import java.util.Scanner;

public class ThreePointCollinear {

    // Method to check collinearity using slope formula
    public static boolean isCollinearBySlope(double x1, double y1, double x2, double y2, double x3, double y3) {
        // Handle vertical line cases to avoid division by zero
        if ((x2 - x1) == 0 || (x3 - x2) == 0 || (x3 - x1) == 0) {
            return ((x2 - x1) == 0 && (x3 - x2) == 0); // all vertical line
        }

        double slopeAB = (y2 - y1) / (x2 - x1);
        double slopeBC = (y3 - y2) / (x3 - x2);
        double slopeAC = (y3 - y1) / (x3 - x1);

        return (slopeAB == slopeBC) && (slopeBC == slopeAC);
    }

    // Method to check collinearity using area of triangle formula
    public static boolean isCollinearByArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        double area = 0.5 * Math.abs(x1 * (y2 - y3) +
                x2 * (y3 - y1) +
                x3 * (y1 - y2));
        return area == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input 3 points
        System.out.print("Enter x1, y1: ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();

        System.out.print("Enter x2, y2: ");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        System.out.print("Enter x3, y3: ");
        double x3 = scanner.nextDouble();
        double y3 = scanner.nextDouble();

        // Check collinearity using slope
        boolean collinearSlope = isCollinearBySlope(x1, y1, x2, y2, x3, y3);

        // Check collinearity using area
        boolean collinearArea = isCollinearByArea(x1, y1, x2, y2, x3, y3);

        System.out.println("\nCollinearity Check:");
        System.out.println("Using Slope Method: " + (collinearSlope ? "Collinear" : "Not Collinear"));
        System.out.println("Using Area Method: " + (collinearArea ? "Collinear" : "Not Collinear"));

        scanner.close();
    }
}
