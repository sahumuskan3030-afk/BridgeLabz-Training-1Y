package com.gla.practiceproblem2;

import java.util.Scanner;

public class PalindromeChecker {

    // Function to take input
    public static String getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        return sc.nextLine();
    }

    // Function to check palindrome
    public static boolean isPalindrome(String str) {

        str = str.replaceAll("\\s+", "").toLowerCase();

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    // Function to display result
    public static void displayResult(String str, boolean result) {
        if (result) {
            System.out.println(str + " is a Palindrome");
        } else {
            System.out.println(str + " is NOT a Palindrome");
        }
    }

    public static void main(String[] args) {

        String input = getInput();
        boolean result = isPalindrome(input);

        displayResult(input, result);
    }
}
