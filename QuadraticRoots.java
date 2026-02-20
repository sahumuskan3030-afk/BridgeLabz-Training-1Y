package com.gla.array.Level2;

import java.util.Scanner;

public class QuadraticRoots {

    public static void findRoots(double a, double b, double c) {

        double discriminant = Math.pow(b, 2) - 4 * a * c;

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);

            System.out.println("Two Real and Distinct Roots:");
            System.out.println("Root 1 = " + root1);
            System.out.println("Root 2 = " + root2);

        } else if (discriminant == 0) {
            double root = -b / (2 * a);

            System.out.println("One Real Root:");
            System.out.println("Root = " + root);

        } else {
            System.out.println("Roots are Complex (Imaginary).");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of a: ");
        double a = sc.nextDouble();

        System.out.print("Enter value of b: ");
        double b = sc.nextDouble();

        System.out.print("Enter value of c: ");
        double c = sc.nextDouble();

        if (a == 0) {
            System.out.println("Not a quadratic equation (a cannot be 0).");
        } else {
            findRoots(a, b, c);
        }

        sc.close();
    }
}
