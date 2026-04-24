package com.gla.regex;

import java.util.regex.*;
import java.util.*;

public class LinkExtractor {

    public static List<String> extractLinks(String text) {
        List<String> links = new ArrayList<>();

        String regex = "https?://[\\w.-]+(?:\\.[\\w.-]+)+(?:[\\w\\-._~:/?#[\\]@!$&'()*+,;=]*)?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            links.add(matcher.group());
        }

        return links;
    }

    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";

        List<String> result = extractLinks(text);
        System.out.println(String.join(", ", result));
    }
}