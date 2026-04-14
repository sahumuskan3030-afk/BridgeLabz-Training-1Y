package com.gla.collection.Task;
import java.util.*;

class Movie {
    int movieId;
    String title;
    String genre;

    public Movie(int movieId, String title, String genre) {
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Movie{id=" + movieId + ", title='" + title + "', genre='" + genre + "'}";
    }
}

public class StreamingSystem {

    public static void main(String[] args) {

        // 1. All movies available
        List<Movie> allMovies = new ArrayList<>();

        // 2. Watch history (stack)
        Stack<Movie> watchHistory = new Stack<>();

        // 3. Unique genres watched
        Set<String> watchedGenres = new HashSet<>();

        // 4. Up next queue
        Queue<Movie> upNext = new LinkedList<>();

        // ---------------------------
        // Add movies to platform
        // ---------------------------
        allMovies.add(new Movie(1, "Inception", "Sci-Fi"));
        allMovies.add(new Movie(2, "Titanic", "Romance"));
        allMovies.add(new Movie(3, "Interstellar", "Sci-Fi"));
        allMovies.add(new Movie(4, "Joker", "Drama"));

        // ---------------------------
        // Add to "Up Next"
        // ---------------------------
        upNext.offer(allMovies.get(0));
        upNext.offer(allMovies.get(1));
        upNext.offer(allMovies.get(2));

        System.out.println("▶ Starting Streaming...\n");

        // ---------------------------
        // Watch movies
        // ---------------------------
        while (!upNext.isEmpty()) {
            Movie current = upNext.poll();
            System.out.println("Watching: " + current);

            // Move to history stack
            watchHistory.push(current);

            // Track genre
            watchedGenres.add(current.genre);
        }

        // ---------------------------
        // Display watch history
        // ---------------------------
        System.out.println("\n📺 Watch History:");
        for (Movie m : watchHistory) {
            System.out.println(m);
        }

        // ---------------------------
        // Display genres
        // ---------------------------
        System.out.println("\n🎯 Unique Genres Watched:");
        for (String g : watchedGenres) {
            System.out.println(g);
        }

        // ---------------------------
        // Generate recommendations
        // ---------------------------
        System.out.println("\n🎬 Recommendations Based on Genres:");
        recommend(allMovies, watchedGenres);
    }

    // Recommendation logic
    public static void recommend(List<Movie> allMovies, Set<String> genres) {
        for (Movie m : allMovies) {
            if (genres.contains(m.genre)) {
                System.out.println("Recommended: " + m);
            }
        }
    }
}
