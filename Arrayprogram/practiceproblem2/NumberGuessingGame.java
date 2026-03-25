package com.gla.practiceproblem2;

import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    // Function to generate guess
    public static int generateGuess(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }

    // Function to get user feedback
    public static String getFeedback(Scanner sc) {
        System.out.print("Enter feedback (high / low / correct): ");
        return sc.nextLine().toLowerCase();
    }

    // Function to update range based on feedback
    public static int[] updateRange(int guess, int min, int max, String feedback) {
        if (feedback.equals("high")) {
            max = guess - 1;
        } else if (feedback.equals("low")) {
            min = guess + 1;
        }
        return new int[]{min, max};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Think of a number between 1 and 100...");

        int min = 1, max = 100;
        int guess;
        String feedback;

        while (true) {
            guess = generateGuess(min, max);
            System.out.println("Computer guess: " + guess);

            feedback = getFeedback(sc);

            if (feedback.equals("correct")) {
                System.out.println("Yay! Computer guessed your number 🎉");
                break;
            }

            int[] range = updateRange(guess, min, max, feedback);
            min = range[0];
            max = range[1];
        }
    }
}
