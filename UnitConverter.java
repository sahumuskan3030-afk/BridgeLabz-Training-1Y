package com.gla.array.Level2;
public class UnitConverter {

    // Kilometers to Miles
    public static double convertKmToMiles(double km) {
        return km * 0.621371;
    }

    // Miles to Kilometers
    public static double convertMilesToKm(double miles) {
        return miles * 1.60934;
    }

    // Meters to Feet
    public static double convertMetersToFeet(double meters) {
        return meters * 3.28084;
    }

    // Feet to Meters
    public static double convertFeetToMeters(double feet) {
        return feet * 0.3048;
    }

    public static void main(String[] args) {

        System.out.println("10 km to miles: " + convertKmToMiles(10));
        System.out.println("5 miles to km: " + convertMilesToKm(5));
        System.out.println("100 meters to feet: " + convertMetersToFeet(100));
        System.out.println("50 feet to meters: " + convertFeetToMeters(50));
    }
}

