package com.gla.regex;

import java.util.*;
import java.util.regex.*;

public class CapitalizedWordExtractor {

    public static List<String> extractCapitalWords(String text) {
        List<String> result = new ArrayList<>();

        String regex = "\\b[A-Z][a-z]*\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String word = matcher.group();

            // Skip common sentence starter like "The"
            if (!word.equals("The")) {
                result.add(word);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";

        List<String> words = extractCapitalWords(text);
        System.out.println(String.join(", ", words));
    }
}
