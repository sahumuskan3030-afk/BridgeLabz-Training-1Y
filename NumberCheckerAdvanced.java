package com.gla.array.Level3;

public class NumberCheckerAdvanced {

    // Count digits
    public static int countDigits(int n) {
        return String.valueOf(Math.abs(n)).length();
    }

    // Store digits
    public static int[] storeDigits(int n) {
        String s = String.valueOf(Math.abs(n));
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++)
            digits[i] = s.charAt(i) - '0';
        return digits;
    }

    // Sum of digits
    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int d : digits)
            sum += d;
        return sum;
    }

    // Sum of squares of digits
    public static double sumOfSquares(int[] digits) {
        double sum = 0;
        for (int d : digits)
            sum += Math.pow(d, 2);
        return sum;
    }

    // Harshad number
    public static boolean isHarshad(int n) {
        int[] digits = storeDigits(n);
        int sum = sumOfDigits(digits);
        return n % sum == 0;
    }

    public static void main(String[] args) {

        int number = 21;

        int[] digits = storeDigits(number);

        System.out.println("Digit Count: " + countDigits(number));
        System.out.println("Sum of Digits: " + sumOfDigits(digits));
        System.out.println("Sum of Squares: " + sumOfSquares(digits));
        System.out.println("Harshad Number: " + isHarshad(number));
    }
}
