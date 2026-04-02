import java.util.Scanner;
import java.util.Random;

public class StudentVoting {

    public static int[] generateRandomAges(int n) {
        int[] ages = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            ages[i] = rand.nextInt(82) + 18; // random age between 18 and 99
        }
        return ages;
    }

    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            if (ages[i] < 0) {
                result[i][0] = String.valueOf(ages[i]);
                result[i][1] = "false";
            } else if (ages[i] >= 18) {
                result[i][0] = String.valueOf(ages[i]);
                result[i][1] = "true";
            } else {
                result[i][0] = String.valueOf(ages[i]);
                result[i][1] = "false";
            }
        }
        return result;
    }

    public static void displayTable(String[][] data) {
        System.out.printf("%-10s%-15s%n", "Age", "Can Vote");
        System.out.println("---------------------");
        for (String[] row : data) {
            System.out.printf("%-10s%-15s%n", row[0], row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            ages[i] = sc.nextInt();
        }

        String[][] eligibility = checkVotingEligibility(ages);
        displayTable(eligibility);
        sc.close();
    }
}
