package com.gla.array.Level3;

import java.util.Random;

public class PlayerInfo {

    // Method to generate random heights for players (150cm to 250cm)
    public static int[] generatePlayerHeights(int numPlayers) {
        Random rand = new Random();
        int[] heights = new int[numPlayers];

        for (int i = 0; i < numPlayers; i++) {
            heights[i] = rand.nextInt(101) + 150; // 0-100 + 150 = 150-250
        }
        return heights;
    }

    // Method to calculate the sum of all elements in the array
    public static int calculateSum(int[] arr) {
        int sum = 0;
        for (int h : arr) {
            sum += h;
        }
        return sum;
    }

    // Method to calculate the mean height
    public static double calculateMean(int[] arr) {
        int sum = calculateSum(arr);
        return (double) sum / arr.length;
    }

    // Method to find the shortest height
    public static int findShortest(int[] arr) {
        int min = arr[0];
        for (int h : arr) {
            if (h < min) {
                min = h;
            }
        }
        return min;
    }

    // Method to find the tallest height
    public static int findTallest(int[] arr) {
        int max = arr[0];
        for (int h : arr) {
            if (h > max) {
                max = h;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int numPlayers = 11; // Standard football team size
        int[] heights = generatePlayerHeights(numPlayers);

        System.out.println("Player Heights (cm):");
        for (int i = 0; i < heights.length; i++) {
            System.out.println("Player " + (i + 1) + ": " + heights[i]);
        }

        int shortest = findShortest(heights);
        int tallest = findTallest(heights);
        double mean = calculateMean(heights);

        System.out.printf("\nShortest Height: %d cm\n", shortest);
        System.out.printf("Tallest Height: %d cm\n", tallest);
        System.out.printf("Mean Height: %.2f cm\n", mean);
    }
}



