import java.util.Scanner;

public class RockPaperScissors {

    public static String getComputerChoice() {
        int choice = (int) (Math.random() * 3);
        switch (choice) {
            case 0: return "rock";
            case 1: return "paper";
            default: return "scissors";
        }
    }

    public static String findWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "draw";
        } else if (
            (userChoice.equals("rock") && computerChoice.equals("scissors")) ||
            (userChoice.equals("paper") && computerChoice.equals("rock")) ||
            (userChoice.equals("scissors") && computerChoice.equals("paper"))
        ) {
            return "user";
        } else {
            return "computer";
        }
    }

    public static String[][] calculateStats(int userWins, int computerWins, int totalGames) {
        String[][] stats = new String[3][2];
        stats[0][0] = "User Wins"; stats[0][1] = String.valueOf(userWins);
        stats[1][0] = "Computer Wins"; stats[1][1] = String.valueOf(computerWins);
        stats[2][0] = "Winning %";
        stats[2][1] = String.format("User: %.2f%%, Computer: %.2f%%", 
            (userWins * 100.0 / totalGames), (computerWins * 100.0 / totalGames));
        return stats;
    }

    public static void displayResults(String[][] gameResults, String[][] stats) {
        System.out.printf("%-10s%-15s%-15s%-10s%n", "Game#", "User Choice", "Computer Choice", "Winner");
        System.out.println("-----------------------------------------------------");
        for (int i = 0; i < gameResults.length; i++) {
            System.out.printf("%-10s%-15s%-15s%-10s%n", i + 1, gameResults[i][0], gameResults[i][1], gameResults[i][2]);
        }
        System.out.println("\nStatistics:");
        for (String[] row : stats) {
            System.out.printf("%-15s : %s%n", row[0], row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of games: ");
        int numGames = sc.nextInt();
        sc.nextLine(); // consume newline

        String[][] gameResults = new String[numGames][3];
        int userWins = 0, computerWins = 0;

        for (int i = 0; i < numGames; i++) {
            System.out.print("Enter your choice (rock/paper/scissors) for game " + (i + 1) + ": ");
            String userChoice = sc.nextLine().toLowerCase();
            String computerChoice = getComputerChoice();
            String winner = findWinner(userChoice, computerChoice);

            if (winner.equals("user")) userWins++;
            else if (winner.equals("computer")) computerWins++;

            gameResults[i][0] = userChoice;
            gameResults[i][1] = computerChoice;
            gameResults[i][2] = winner;
        }

        String[][] stats = calculateStats(userWins, computerWins, numGames);
        displayResults(gameResults, stats);
        sc.close();
    }
}
