import java.util.Scanner;

public class AnagramChecker {

    public static boolean areAnagrams(String text1, String text2) {
        text1 = text1.replaceAll("\\s+", "").toLowerCase();
        text2 = text2.replaceAll("\\s+", "").toLowerCase();

        if (text1.length() != text2.length()) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < text1.length(); i++) {
            char ch1 = text1.charAt(i);
            char ch2 = text2.charAt(i);
            if (Character.isLetter(ch1)) freq1[ch1 - 'a']++;
            if (Character.isLetter(ch2)) freq2[ch2 - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first text: ");
        String text1 = sc.nextLine();

        System.out.print("Enter second text: ");
        String text2 = sc.nextLine();

        if (areAnagrams(text1, text2)) {
            System.out.println("\"" + text1 + "\" and \"" + text2 + "\" are anagrams.");
        } else {
            System.out.println("\"" + text1 + "\" and \"" + text2 + "\" are NOT anagrams.");
        }

        sc.close();
    }
}
