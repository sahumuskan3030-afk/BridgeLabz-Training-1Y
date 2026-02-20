package com.gla.array.Level3;

import java.util.Arrays;

public class NumberChecker {

    // Count digits
    public static int countDigits(int n) {
        return String.valueOf(Math.abs(n)).length();
    }

    // Store digits in array
    public static int[] storeDigits(int n) {
        String s = String.valueOf(Math.abs(n));
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++)
            digits[i] = s.charAt(i) - '0';
        return digits;
    }

    // Duck number (contains zero but not starting zero)
    public static boolean isDuckNumber(int[] digits) {
        for (int d : digits)
            if (d == 0)
                return true;
        return false;
    }

    // Armstrong number
    public static boolean isArmstrong(int n) {
        int[] digits = storeDigits(n);
        int power = digits.length;
        int sum = 0;

        for (int d : digits)
            sum += Math.pow(d, power);

        return sum == n;
    }

    // Largest & Second Largest
    public static int[] findLargestSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int d : digits) {
            if (d > largest) {
                second = largest;
                largest = d;
            } else if (d > second && d != largest) {
                second = d;
            }
        }
        return new int[]{largest, second};
    }

    // Smallest & Second Smallest
    public static int[] findSmallestSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int d : digits) {
            if (d < smallest) {
                second = smallest;
                smallest = d;
            } else if (d < second && d != smallest) {
                second = d;
            }
        }
        return new int[]{smallest, second};
    }

    public static void main(String[] args) {

        int number = 153;

        int[] digits = storeDigits(number);

        System.out.println("Digit Count: " + countDigits(number));
        System.out.println("Digits: " + Arrays.toString(digits));
        System.out.println("Duck Number: " + isDuckNumber(digits));
        System.out.println("Armstrong Number: " + isArmstrong(number));

        int[] large = findLargestSecondLargest(digits);
        System.out.println("Largest: " + large[0] + ", Second Largest: " + large[1]);

        int[] small = findSmallestSecondSmallest(digits);
        System.out.println("Smallest: " + small[0] + ", Second Smallest: " + small[1]);
    }
}
