package com.gla.practiceproblem2;

import java.util.Scanner;

public class GCDLCMCalculator {

    // Function to take input
    public static int[] takeInput() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        return new int[]{a, b};
    }

    // Function to calculate GCD using Euclidean Algorithm
    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Function to calculate LCM
    public static int findLCM(int a, int b) {
        int gcd = findGCD(a, b);
        return (a * b) / gcd;
    }

    public static void main(String[] args) {

        int[] numbers = takeInput();
        int a = numbers[0];
        int b = numbers[1];

        int gcd = findGCD(a, b);
        int lcm = findLCM(a, b);

        System.out.println("GCD of " + a + " and " + b + " is: " + gcd);
        System.out.println("LCM of " + a + " and " + b + " is: " + lcm);
    }
}
