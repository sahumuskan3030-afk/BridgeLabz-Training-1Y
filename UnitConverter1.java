package com.gla.array.Level2;

public class UnitConverter1 {

    // ===== Question 5 Conversions =====

    // Yards to Feet
    public static double convertYardsToFeet(double yards) {
        double yards2feet = 3;
        return yards * yards2feet;
    }

    // Feet to Yards
    public static double convertFeetToYards(double feet) {
        double feet2yards = 0.333333;
        return feet * feet2yards;
    }

    // Meters to Inches
    public static double convertMetersToInches(double meters) {
        double meters2inches = 39.3701;
        return meters * meters2inches;
    }

    // Inches to Meters
    public static double convertInchesToMeters(double inches) {
        double inches2meters = 0.0254;
        return inches * inches2meters;
    }

    // Inches to Centimeters
    public static double convertInchesToCentimeters(double inches) {
        double inches2cm = 2.54;
        return inches * inches2cm;
    }


    // ===== Question 6 Conversions =====

    // Fahrenheit to Celsius
    public static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    // Celsius to Fahrenheit
    public static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // Pounds to Kilograms
    public static double convertPoundsToKilograms(double pounds) {
        double pounds2kilograms = 0.453592;
        return pounds * pounds2kilograms;
    }

    // Kilograms to Pounds
    public static double convertKilogramsToPounds(double kilograms) {
        double kilograms2pounds = 2.20462;
        return kilograms * kilograms2pounds;
    }

    // Gallons to Liters
    public static double convertGallonsToLiters(double gallons) {
        double gallons2liters = 3.78541;
        return gallons * gallons2liters;
    }

    // Liters to Gallons
    public static double convertLitersToGallons(double liters) {
        double liters2gallons = 0.264172;
        return liters * liters2gallons;
    }


    // ===== Main Method for Testing =====

    public static void main(String[] args) {

        System.out.println("10 yards to feet: " + convertYardsToFeet(10));
        System.out.println("30 feet to yards: " + convertFeetToYards(30));
        System.out.println("2 meters to inches: " + convertMetersToInches(2));
        System.out.println("20 inches to meters: " + convertInchesToMeters(20));
        System.out.println("15 inches to cm: " + convertInchesToCentimeters(15));

        System.out.println("100°F to Celsius: " + convertFahrenheitToCelsius(100));
        System.out.println("37°C to Fahrenheit: " + convertCelsiusToFahrenheit(37));
        System.out.println("50 pounds to kg: " + convertPoundsToKilograms(50));
        System.out.println("70 kg to pounds: " + convertKilogramsToPounds(70));
        System.out.println("5 gallons to liters: " + convertGallonsToLiters(5));
        System.out.println("10 liters to gallons: " + convertLitersToGallons(10));
    }
}
