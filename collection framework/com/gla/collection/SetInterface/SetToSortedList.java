package com.gla.collection.SetInterface;

import java.util.*;

public class SetToSortedList {

    public static List<Integer> convertAndSort(Set<Integer> set) {

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list); // Ascending order

        return list;
    }

    public static void main(String[] args) {

        Set<Integer> set = new HashSet<>(Arrays.asList(5, 3, 9, 1));

        System.out.println("Input Set: " + set);

        List<Integer> sortedList = convertAndSort(set);

        System.out.println("Sorted List: " + sortedList);
    }
}
