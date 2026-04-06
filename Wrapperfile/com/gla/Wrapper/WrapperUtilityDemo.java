package com.gla.Wrapper;

public class WrapperUtilityDemo {
    public static void main(String[] args) {

        // Integer.parseInt()
        int intValue = Integer.parseInt("123");

        // Double.parseDouble()
        double doubleValue = Double.parseDouble("3.14");

        // Boolean.parseBoolean()
        boolean boolValue = Boolean.parseBoolean("true");

        // Integer.toBinaryString()
        String binaryValue = Integer.toBinaryString(10);

        // Character.isDigit()
        boolean isDigit = Character.isDigit('5');

        // Character.toUpperCase()
        char upperChar = Character.toUpperCase('a');

        // Print results
        System.out.println("Integer.parseInt(\"123\") = " + intValue);
        System.out.println("Double.parseDouble(\"3.14\") = " + doubleValue);
        System.out.println("Boolean.parseBoolean(\"true\") = " + boolValue);
        System.out.println("Integer.toBinaryString(10) = " + binaryValue);
        System.out.println("Character.isDigit('5') = " + isDigit);
        System.out.println("Character.toUpperCase('a') = " + upperChar);
    }
}