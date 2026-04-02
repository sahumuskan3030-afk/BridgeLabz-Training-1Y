import java.util.Scanner;

public class PalindromeChecker {

    // Logic 1: Iterative method
    public static boolean isPalindromeIterative(String text) {
        text = text.replaceAll("\\s+", "").toLowerCase();
        int start = 0, end = text.length() - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    // Logic 2: Recursive method
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        text = text.replaceAll("\\s+", "").toLowerCase();
        if (start >= end) return true;
        if (text.charAt(start) != text.charAt(end)) return false;
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // Logic 3: Using char arrays and reversal
    public static boolean isPalindromeCharArray(String text) {
        text = text.replaceAll("\\s+", "").toLowerCase();
        char[] original = text.toCharArray();
        char[] reverse = reverseCharArray(text);
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reverse[i]) return false;
        }
        return true;
    }

    public static char[] reverseCharArray(String text) {
        char[] reversed = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            reversed[i] = text.charAt(text.length() - 1 - i);
        }
        return reversed;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text to check palindrome: ");
        String text = sc.nextLine();

        boolean result1 = isPalindromeIterative(text);
        boolean result2 = isPalindromeRecursive(text, 0, text.replaceAll("\\s+", "").length() - 1);
        boolean result3 = isPalindromeCharArray(text);

        System.out.println("Using Iterative method: " + (result1 ? "Palindrome" : "Not Palindrome"));
        System.out.println("Using Recursive method: " + (result2 ? "Palindrome" : "Not Palindrome"));
        System.out.println("Using Char Array method: " + (result3 ? "Palindrome" : "Not Palindrome"));

        sc.close();
    }
}
