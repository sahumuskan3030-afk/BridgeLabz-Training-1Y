package com.gla.array.Level2;

import java.util.Scanner;

public class NumberAnalysis {

    // Check positive or negative
    public static String checkSign(int num) {
        if (num > 0)
            return "Positive";
        else if (num < 0)
            return "Negative";
        else
            return "Zero";
    }

    // Check even or odd
    public static String checkEvenOdd(int num) {
        if (num % 2 == 0)
            return "Even";
        else
            return "Odd";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();

            String sign = checkSign(numbers[i]);
            System.out.println("Number is " + sign);

            if (numbers[i] > 0) {
                System.out.println("It is " + checkEvenOdd(numbers[i]));
            }
        }

        // Compare first and last element
        if (numbers[0] == numbers[4])
            System.out.println("First and last numbers are equal.");
        else if (numbers[0] > numbers[4])
            System.out.println("First number is greater than last number.");
        else
            System.out.println("First number is less than last number.");

        sc.close();
    }
}
