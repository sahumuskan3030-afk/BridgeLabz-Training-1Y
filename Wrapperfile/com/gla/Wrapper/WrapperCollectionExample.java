package com.gla.Wrapper;

import java.util.ArrayList;

public class WrapperCollectionExample {
    public static void main(String[] args) {

        // Given array of primitive doubles
        double[] prices = {10.5, 20.0, 35.75, 5.5};

        // Convert to ArrayList<Double> (auto-boxing)
        ArrayList<Double> priceList = new ArrayList<>();

        for (double price : prices) {
            priceList.add(price); // auto-boxing (double → Double)
        }

        // Find highest price and calculate sum
        double max = priceList.get(0);
        double sum = 0;

        for (Double price : priceList) {
            if (price > max) {
                max = price;
            }
            sum += price; // auto-unboxing (Double → double)
        }

        double average = sum / priceList.size();

        // Print results
        System.out.println("Prices: " + priceList);
        System.out.println("Highest price: " + max);
        System.out.println("Average price: " + average);
    }
}
