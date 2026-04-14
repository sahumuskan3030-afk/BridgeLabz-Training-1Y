package com.gla.collection.MapInterface;

import java.util.*;

public class CountryCapitalLookup {

    public static void main(String[] args) {

        // 1. Create map: Country -> Capital
        Map<String, String> map = new HashMap<>();

        // Add at least 8 country-capital pairs
        map.put("India", "New Delhi");
        map.put("Japan", "Tokyo");
        map.put("France", "Paris");
        map.put("Germany", "Berlin");
        map.put("USA", "Washington DC");
        map.put("Canada", "Ottawa");
        map.put("Australia", "Canberra");
        map.put("Brazil", "Brasilia");

        // 2. User input for lookup
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a country name to find its capital: ");
        String country = sc.nextLine();

        if (map.containsKey(country)) {
            System.out.println("Capital of " + country + " is " + map.get(country));
        } else {
            System.out.println("Unknown country");
        }

        // 3. Print all countries in alphabetical order
        System.out.println("\nCountries and Capitals (Sorted):");

        Map<String, String> sortedMap = new TreeMap<>(map);

        for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        sc.close();
    }
}
