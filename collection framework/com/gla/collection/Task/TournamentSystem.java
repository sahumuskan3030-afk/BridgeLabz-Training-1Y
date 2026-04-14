package com.gla.collection.Task;

import java.util.Objects;
import java.util.*;
class Player {
    int playerId;
    String name;

    public Player(int playerId, String name) {
        this.playerId = playerId;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player p = (Player) o;
        return playerId == p.playerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId);
    }

    @Override
    public String toString() {
        return name + " (ID: " + playerId + ")";
    }
}
class Match {
    Player player1;
    Player player2;

    public Match(Player p1, Player p2) {
        this.player1 = p1;
        this.player2 = p2;
    }

    @Override
    public String toString() {
        return player1 + " vs " + player2;
    }
}
class Result {
    Match match;
    Player winner;

    public Result(Match match, Player winner) {
        this.match = match;
        this.winner = winner;
    }

    @Override
    public String toString() {
        return match + " | Winner: " + winner;
    }
}
class Score implements Comparable<Score> {
    Player player;
    int points;

    public Score(Player player, int points) {
        this.player = player;
        this.points = points;
    }

    @Override
    public int compareTo(Score other) {
        // Descending order
        int cmp = Integer.compare(other.points, this.points);
        if (cmp == 0) {
            return Integer.compare(this.player.playerId, other.player.playerId);
        }
        return cmp;
    }

    @Override
    public String toString() {
        return player + " -> " + points + " pts";
    }
}


public class TournamentSystem {

    public static void main(String[] args) {

        // 1. Register players (Set)
        Set<Player> players = new HashSet<>();

        Player p1 = new Player(1, "Alice");
        Player p2 = new Player(2, "Bob");
        Player p3 = new Player(3, "Charlie");
        Player p4 = new Player(1, "Duplicate Alice"); // duplicate

        registerPlayer(players, p1);
        registerPlayer(players, p2);
        registerPlayer(players, p3);
        registerPlayer(players, p4);

        // 2. Schedule matches (Queue)
        Queue<Match> matchQueue = new LinkedList<>();
        matchQueue.offer(new Match(p1, p2));
        matchQueue.offer(new Match(p2, p3));

        // 3. Store results
        List<Result> results = new ArrayList<>();

        // 4. Leaderboard (TreeSet)
        TreeSet<Score> leaderboard = new TreeSet<>();

        // Initialize scores
        Map<Player, Integer> scoreMap = new HashMap<>();
        for (Player p : players) {
            scoreMap.put(p, 0);
        }

        System.out.println("\nProcessing Matches...\n");

        while (!matchQueue.isEmpty()) {
            Match match = matchQueue.poll();
            System.out.println("Playing: " + match);

            // Simulate winner
            Player winner = new Random().nextBoolean() ? match.player1 : match.player2;

            System.out.println("Winner: " + winner);

            // Update results
            results.add(new Result(match, winner));

            // Update score
            scoreMap.put(winner, scoreMap.get(winner) + 10);
        }

        // Update leaderboard
        for (Map.Entry<Player, Integer> entry : scoreMap.entrySet()) {
            leaderboard.add(new Score(entry.getKey(), entry.getValue()));
        }

        // Display leaderboard
        System.out.println("\nLeaderboard:");
        for (Score score : leaderboard) {
            System.out.println(score);
        }

        // Display results
        System.out.println("\nMatch Results:");
        for (Result r : results) {
            System.out.println(r);
        }
    }

    public static void registerPlayer(Set<Player> players, Player p) {
        if (players.add(p)) {
            System.out.println("Registered: " + p);
        } else {
            System.out.println("Duplicate player rejected: " + p);
        }
    }
}
