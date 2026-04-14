package com.gla.collection.MapInterface;

import java.util.*;

public class WebsiteVisitTracker {

    public static void main(String[] args) {

        // Map: Page -> Visit Count
        Map<String, Integer> visits = new HashMap<>();

        // Simulated page visits
        String[] sessionVisits = {
                "home", "about", "products", "home",
                "products", "contact", "home", "products",
                "home", "blog", "contact", "products"
        };

        // 1. Track visits
        for (String page : sessionVisits) {
            visits.put(page, visits.getOrDefault(page, 0) + 1);
        }

        // 2. Print visits sorted by descending count
        System.out.println("Pages sorted by visit count (descending):");

        List<Map.Entry<String, Integer>> list = new ArrayList<>(visits.entrySet());

        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // 3. Find most visited page
        String mostVisitedPage = null;
        int maxVisits = 0;

        for (Map.Entry<String, Integer> entry : visits.entrySet()) {
            if (entry.getValue() > maxVisits) {
                maxVisits = entry.getValue();
                mostVisitedPage = entry.getKey();
            }
        }

        System.out.println("\nMost Visited Page:");
        System.out.println(mostVisitedPage + " -> " + maxVisits + " visits");
    }
}
