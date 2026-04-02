package com.gla.stringproblem;

import java.util.Scanner;

public class LongestWordFinder {

    public static String findLongestWord(String sentence) {

        String[] words = sentence.split("\\s+");

        String longestWord = "";

        for (String word : words) {

            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        return longestWord;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        String result = findLongestWord(input);

        System.out.println("Longest word: " + result);
    }
}
