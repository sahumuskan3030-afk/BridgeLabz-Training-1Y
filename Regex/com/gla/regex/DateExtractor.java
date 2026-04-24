package com.gla.regex;

import java.util.regex.*;
import java.util.*;

public class DateExtractor {

    public static List<String> extractDates(String text) {
        List<String> dates = new ArrayList<>();

        String regex = "\\b\\d{2}/\\d{2}/\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            dates.add(matcher.group());
        }

        return dates;
    }

    public static void main(String[] args) {
        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";

        List<String> result = extractDates(text);
        System.out.println(String.join(", ", result));
    }
}
