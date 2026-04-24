package com.gla.regex;

import java.util.regex.*;
import java.util.*;

public class EmailExtractor {

    public static List<String> extractEmails(String text) {
        List<String> emails = new ArrayList<>();

        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            emails.add(matcher.group());
        }

        return emails;
    }

    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org";

        List<String> result = extractEmails(text);
        for (String email : result) {
            System.out.println(email);
        }
    }
}