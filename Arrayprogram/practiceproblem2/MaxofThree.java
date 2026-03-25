package com.gla.practiceproblem2;

import java.util.Scanner;

public class MaxofThree {

    // Function to take input
    public static int[] takeInput() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        System.out.print("Enter third number: ");
        int c = sc.nextInt();

        return new int[]{a, b, c};
    }

    // Function to find maximum
    public static int findMax(int a, int b, int c) {
        int max = a;

        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }

        return max;
    }

    public static void main(String[] args) {

        int[] numbers = takeInput();

        int max = findMax(numbers[0], numbers[1], numbers[2]);

        System.out.println("Maximum number is: " + max);
    }
}
