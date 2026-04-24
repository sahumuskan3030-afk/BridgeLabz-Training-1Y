package com.gla.regex;

import java.util.regex.*;
import java.util.*;

public class CapitalizedWordsExtractor {

    public static List<String> extractCapitalizedWords(String text) {
        List<String> words = new ArrayList<>();

        String regex = "\\b[A-Z][a-z]*\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            words.add(matcher.group());
        }

        return words;
    }

    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";

        List<String> result = extractCapitalizedWords(text);
        System.out.println(String.join(", ", result));
    }
}
