import java.util.Scanner;

public class LowercaseCompare {

    // Method to convert string to lowercase manually using ASCII
    public static String toLowerManual(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32); // convert uppercase to lowercase
            }
            result.append(ch);
        }
        return result.toString();
    }

    // Method to compare two strings character by character
    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter complete text: ");
        String input = sc.nextLine();

        // Convert using user-defined method
        String manualLower = toLowerManual(input);

        // Convert using built-in method
        String builtinLower = input.toLowerCase();

        // Compare both results
        boolean match = compareStrings(manualLower, builtinLower);

        System.out.println("\nManual lowercase conversion: " + manualLower);
        System.out.println("Built-in lowercase conversion: " + builtinLower);
        System.out.println("Do both results match? " + match);

        sc.close();
    }
}
