package com.gla.stringproblem;

import java.util.Scanner;

public class CompareStrings {

    // Function to compare two strings
    public static void compare(String s1, String s2) {

        int len1 = s1.length();
        int len2 = s2.length();
        int minLen = Math.min(len1, len2);

        for (int i = 0; i < minLen; i++) {

            if (s1.charAt(i) < s2.charAt(i)) {
                System.out.println("\"" + s1 + "\" comes before \"" + s2 + "\"");
                return;
            } else if (s1.charAt(i) > s2.charAt(i)) {
                System.out.println("\"" + s2 + "\" comes before \"" + s1 + "\"");
                return;
            }
        }

        // Agar sab characters same hain
        if (len1 < len2) {
            System.out.println("\"" + s1 + "\" comes before \"" + s2 + "\"");
        } else if (len1 > len2) {
            System.out.println("\"" + s2 + "\" comes before \"" + s1 + "\"");
        } else {
            System.out.println("Both strings are equal");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();

        compare(s1, s2);
    }
}
