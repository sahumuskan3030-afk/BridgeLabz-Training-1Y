package com.gla.regex;

import java.util.*;

public class BadWordCensor {

    public static String censorText(String text, List<String> badWords) {
        for (String word : badWords) {
            String regex = "(?i)\\b" + word + "\\b"; // (?i) = case-insensitive
            text = text.replaceAll(regex, "****");
        }
        return text;
    }

    public static void main(String[] args) {
        String input = "This is a damn bad example with some stupid words.";
        List<String> badWords = Arrays.asList("damn", "stupid");

        String result = censorText(input, badWords);
        System.out.println(result);
    }
}
