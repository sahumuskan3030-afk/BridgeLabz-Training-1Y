import java.util.Scanner;

public class CharacterFrequency {

    public static String[] findFrequency(String text) {
        text = text.replaceAll("\\s+", ""); // Remove spaces
        char[] chars = text.toCharArray();
        int n = chars.length;
        int[] freq = new int[n];

        for (int i = 0; i < n; i++) {
            if (chars[i] == '0') continue; // Skip already counted duplicates
            freq[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0'; // Mark duplicate
                }
            }
        }

        // Count how many unique characters
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] != '0') count++;
        }

        // Create a 1D String array with "character: frequency"
        String[] result = new String[count];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] != '0') {
                result[index++] = chars[i] + ": " + freq[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[] frequencies = findFrequency(text);

        System.out.println("Character frequencies:");
        for (String s : frequencies) {
            System.out.println(s);
        }

        sc.close();
    }
}
