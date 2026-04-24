package com.gla.regex;

import java.util.*;
import java.util.regex.*;

public class LanguageExtractor {

    public static List<String> extractLanguages(String text) {
        List<String> result = new ArrayList<>();

        // List of programming languages to look for
        String[] languages = {"Java", "Python", "JavaScript", "Go"};

        for (String lang : languages) {
            String regex = "\\b" + lang + "\\b";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);

            if (matcher.find()) {
                result.add(lang);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        List<String> languages = extractLanguages(text);
        System.out.println(String.join(", ", languages));
    }
}
