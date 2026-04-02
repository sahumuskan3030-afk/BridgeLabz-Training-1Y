package com.gla.stringproblem;

import java.util.Scanner;

public class SubstringCount {

    // Function to count occurrences
    public static int countOccurrences(String str, String sub) {

        int count = 0;
        int index = 0;

        while ((index = str.indexOf(sub, index)) != -1) {
            count++;
            index = index + sub.length(); // move forward
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter main string: ");
        String str = sc.nextLine();

        System.out.print("Enter substring: ");
        String sub = sc.nextLine();

        int result = countOccurrences(str, sub);

        System.out.println("Occurrences: " + result);
    }
}
