package com.gla.array.Level1;
import java.util.Scanner;

public class MinMaxThreeNumbers {

    public static void findMinMax(int a, int b, int c) {

        int smallest = a;
        int largest = a;

        if (b < smallest)
            smallest = b;
        if (c < smallest)
            smallest = c;

        if (b > largest)
            largest = b;
        if (c > largest)
            largest = c;

        System.out.println("Smallest number: " + smallest);
        System.out.println("Largest number: " + largest);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        System.out.print("Enter third number: ");
        int c = sc.nextInt();

        findMinMax(a, b, c);

        sc.close();
    }
}

