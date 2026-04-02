package com.gla.stringproblem;

import java.util.Scanner;

public class MostFrequentCharacter {

    public static void findMostFrequent(String str) {

        int[] freq = new int[256]; // ASCII characters

        str = str.toLowerCase();

        // Count frequency
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch != ' ') { // spaces ignore
                freq[ch]++;
            }
        }

        int max = 0;
        char result = ' ';

        // Find max frequency character
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch != ' ' && freq[ch] > max) {
                max = freq[ch];
                result = ch;
            }
        }

        System.out.println("Most Frequent Character: '" + result + "'");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        findMostFrequent(input);
    }
}
