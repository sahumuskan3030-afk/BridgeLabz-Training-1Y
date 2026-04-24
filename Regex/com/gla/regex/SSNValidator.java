package com.gla.regex;

import java.util.regex.*;

public class SSNValidator {

    public static boolean isValidSSN(String ssn) {
        String regex = "^\\d{3}-\\d{2}-\\d{4}$";
        return ssn.matches(regex);
    }

    public static String extractSSN(String text) {
        String regex = "\\b\\d{3}-\\d{2}-\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    public static void main(String[] args) {
        String input1 = "123-45-6789";
        String input2 = "123456789";

        System.out.println("Validation Results:");
        System.out.println(input1 + " → " + (isValidSSN(input1) ? "Valid" : "Invalid"));
        System.out.println(input2 + " → " + (isValidSSN(input2) ? "Valid" : "Invalid"));

        String text = "My SSN is 123-45-6789.";
        String extracted = extractSSN(text);

        System.out.println("\nExtracted SSN: " + extracted);
    }
}
