import java.util.Scanner;

public class UniqueCharFrequency {

    // Method to find unique characters in a string using nested loops
    public static char[] uniqueCharacters(String text) {
        text = text.replaceAll("\\s+", ""); // remove spaces
        String unique = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == ch) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                unique += ch;
            }
        }
        return unique.toCharArray();
    }

    // Method to find frequency of characters and return 2D array
    public static String[][] charFrequency(String text) {
        int[] freq = new int[256]; // ASCII table
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        char[] uniqueChars = uniqueCharacters(text);
        String[][] result = new String[uniqueChars.length][2];

        for (int i = 0; i < uniqueChars.length; i++) {
            result[i][0] = String.valueOf(uniqueChars[i]);
            result[i][1] = String.valueOf(freq[uniqueChars[i]]);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[][] frequencies = charFrequency(text);

        System.out.println("Character frequencies:");
        System.out.printf("%-10s%-10s%n", "Character", "Frequency");
        for (String[] row : frequencies) {
            System.out.printf("%-10s%-10s%n", row[0], row[1]);
        }

        sc.close();
    }
}
