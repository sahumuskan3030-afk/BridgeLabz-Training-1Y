package com.gla.stringproblem;

import java.util.Scanner;

public class RemoveDuplicates {

    // Function to remove duplicate characters
    public static String removeDuplicates(String str) {

        String result = "";

        str = str.toLowerCase(); // optional: case ignore karne ke liye

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            // Check if character already exists in result
            if (result.indexOf(ch) == -1) {
                result = result + ch;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String result = removeDuplicates(input);

        System.out.println("String after removing duplicates: " + result);
    }
}
