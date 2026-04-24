package com.gla.regex;

public class CreditCardValidator {

    public static boolean isValidCard(String cardNumber) {
        // Remove spaces or hyphens if any
        cardNumber = cardNumber.replaceAll("[\\s-]", "");

        String visaRegex = "^4\\d{15}$";
        String masterCardRegex = "^5\\d{15}$";

        return cardNumber.matches(visaRegex) || cardNumber.matches(masterCardRegex);
    }

    public static void main(String[] args) {
        System.out.println(isValidCard("4123456789012345")); // true (Visa)
        System.out.println(isValidCard("5123456789012345")); // true (MasterCard)
        System.out.println(isValidCard("6123456789012345")); // false
        System.out.println(isValidCard("412345678901234"));  // false
    }
}
