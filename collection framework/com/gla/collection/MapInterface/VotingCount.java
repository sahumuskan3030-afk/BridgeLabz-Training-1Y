package com.gla.collection.MapInterface;

import java.util.*;

public class VotingCount {

    public static void main(String[] args) {

        // Map to store candidate -> vote count
        Map<String, Integer> votes = new HashMap<>();

        // Simulating 10 votes
        String[] voteStream = {
                "Aman", "Ravi", "Zara", "Aman", "Ravi",
                "Aman", "Meena", "Zara", "Ravi", "Aman"
        };

        // 1. Count votes
        for (String candidate : voteStream) {
            if (votes.containsKey(candidate)) {
                votes.put(candidate, votes.get(candidate) + 1);
            } else {
                votes.put(candidate, 1);
            }
        }

        // 2. Print all candidate vote counts
        System.out.println("Vote Results:");
        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes");
        }

        // 3. Find winner (highest votes)
        String winner = null;
        int maxVotes = 0;

        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }

        // 4. Print winner
        System.out.println("\nWinner: " + winner + " with " + maxVotes + " votes");
    }
}

