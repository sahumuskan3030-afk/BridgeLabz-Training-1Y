package com.gla.regex;

import java.util.*;
import java.util.regex.*;

public class RepeatingWordsFinder {

    public static List<String> findRepeatingWords(String text) {
        List<String> result = new ArrayList<>();

        // \b(\w+)\s+\1\b → captures repeated consecutive words
        String regex = "\\b(\\w+)\\s+\\1\\b";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            result.add(matcher.group(1));
        }

        return result;
    }

    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";

        List<String> repeats = findRepeatingWords(text);
        System.out.println(String.join(", ", repeats));
    }
}
