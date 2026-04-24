package com.gla.regex;

public class UsernameValidator {

    public static boolean isValidUsername(String username) {
        String regex = "^[A-Za-z][A-Za-z0-9_]{4,14}$";
        return username.matches(regex);
    }

    public static void main(String[] args) {
        System.out.println(isValidUsername("user_123")); // true
        System.out.println(isValidUsername("123user"));  // false
        System.out.println(isValidUsername("us"));       // false
    }
}
