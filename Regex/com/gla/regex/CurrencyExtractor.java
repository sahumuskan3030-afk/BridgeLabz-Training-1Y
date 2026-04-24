package com.gla.regex;

import java.util.*;
import java.util.regex.*;

public class CurrencyExtractor {

    public static List<String> extractAmounts(String text) {
        List<String> result = new ArrayList<>();

        // Matches $45.99, 10.50, etc.
        String regex = "\\$?\\d+(?:\\.\\d{1,2})?";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            result.add(matcher.group());
        }

        return result;
    }

    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";

        List<String> values = extractAmounts(text);
        System.out.println(String.join(", ", values));
    }
}

