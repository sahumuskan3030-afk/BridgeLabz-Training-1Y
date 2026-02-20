package com.gla.array.Level3;

import java.util.Random;

public class FootballTeam {

    // Method to find sum
    public static int findSum(int[] arr) {
        int sum = 0;
        for (int num : arr)
            sum += num;
        return sum;
    }

    // Method to find mean
    public static double findMean(int[] arr) {
        return (double) findSum(arr) / arr.length;
    }

    // Method to find shortest
    public static int findShortest(int[] arr) {
        int min = arr[0];
        for (int num : arr)
            if (num < min)
                min = num;
        return min;
    }

    // Method to find tallest
    public static int findTallest(int[] arr) {
        int max = arr[0];
        for (int num : arr)
            if (num > max)
                max = num;
        return max;
    }

    public static void main(String[] args) {

        int[] heights = new int[11];
        Random rand = new Random();

        for (int i = 0; i < heights.length; i++) {
            heights[i] = 150 + rand.nextInt(101); // 150–250
            System.out.println("Player " + (i + 1) + " Height: " + heights[i]);
        }

        System.out.println("\nMean Height: " + findMean(heights));
        System.out.println("Shortest Height: " + findShortest(heights));
        System.out.println("Tallest Height: " + findTallest(heights));
    }
}
