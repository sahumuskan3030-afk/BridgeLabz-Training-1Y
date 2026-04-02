package com.gla.stringproblem;

import java.util.Scanner;

public class ToggleCase {

    // Function to toggle case
    public static String toggle(String str) {

        String result = "";

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (Character.isUpperCase(ch)) {
                result += Character.toLowerCase(ch);
            } else if (Character.isLowerCase(ch)) {
                result += Character.toUpperCase(ch);
            } else {
                result += ch; // numbers/symbols same rahenge
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String result = toggle(input);

        System.out.println("Toggled string: " + result);
    }
}
