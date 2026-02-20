package com.gla.array.Level2;
import java.util.Scanner;

public class FactorsProgram {

    // Method to find factors and return array
    public static int[] findFactors(int n) {

        int count = 0;

        // First loop → count factors
        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                count++;
        }

        int[] factors = new int[count];
        int index = 0;

        // Second loop → store factors
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                factors[index++] = i;
            }
        }

        return factors;
    }

    public static int sumOfFactors(int[] arr) {
        int sum = 0;
        for (int num : arr)
            sum += num;
        return sum;
    }

    public static int productOfFactors(int[] arr) {
        int product = 1;
        for (int num : arr)
            product *= num;
        return product;
    }

    public static double sumOfSquareOfFactors(int[] arr) {
        double sum = 0;
        for (int num : arr)
            sum += Math.pow(num, 2);
        return sum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        int[] factors = findFactors(n);

        System.out.print("Factors: ");
        for (int f : factors)
            System.out.print(f + " ");

        System.out.println("\nSum of factors: " + sumOfFactors(factors));
        System.out.println("Product of factors: " + productOfFactors(factors));
        System.out.println("Sum of square of factors: " + sumOfSquareOfFactors(factors));

        sc.close();
    }
}
