package com.gla.regex;

public class IPAddressValidator {

    public static boolean isValidIPv4(String ip) {
        String[] parts = ip.split("\\.");

        if (parts.length != 4) return false;

        for (String part : parts) {
            // Must not be empty
            if (part.length() == 0) return false;

            // No leading spaces or trailing spaces
            if (part.startsWith("+") || part.startsWith("-")) return false;

            // Must be numeric only
            if (!part.matches("\\d+")) return false;

            // No leading zeros like "01" (optional rule, commonly required)
            if (part.length() > 1 && part.startsWith("0")) return false;

            int num = Integer.parseInt(part);

            if (num < 0 || num > 255) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidIPv4("192.168.1.1"));     // true
        System.out.println(isValidIPv4("255.255.255.255")); // true
        System.out.println(isValidIPv4("256.100.50.25"));    // false
        System.out.println(isValidIPv4("192.168.01.1"));     // false
    }
}
