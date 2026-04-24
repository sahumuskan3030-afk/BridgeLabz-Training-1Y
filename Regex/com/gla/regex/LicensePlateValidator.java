package com.gla.regex;

public class LicensePlateValidator {

    public static boolean isValidPlate(String plate) {
        String regex = "^[A-Z]{2}[0-9]{4}$";
        return plate.matches(regex);
    }

    public static void main(String[] args) {
        System.out.println(isValidPlate("AB1234")); // true
        System.out.println(isValidPlate("A12345")); // false
        System.out.println(isValidPlate("ab1234")); // false
    }
}
