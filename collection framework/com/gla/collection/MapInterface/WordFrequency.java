package com.gla.collection.MapInterface;

import java.util.*;

public class WordFrequency {

    public static void main(String[] args) {

        String sentence = "Java is fun and Java is powerful";

        // Step 1: Normalize (lowercase + remove punctuation)
        sentence = sentence.toLowerCase().replaceAll("[^a-z\\s]", "");

        // Step 2: Split into words
        String[] words = sentence.split("\\s+");

        // Step 3: Map to store word frequency
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String word : words) {
            if (frequencyMap.containsKey(word)) {
                frequencyMap.put(word, frequencyMap.get(word) + 1);
            } else {
                frequencyMap.put(word, 1);
            }
        }

        // Step 4: Print results
        System.out.println("Word Frequency Count:");

        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
