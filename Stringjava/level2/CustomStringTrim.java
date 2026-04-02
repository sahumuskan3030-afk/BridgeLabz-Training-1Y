import java.util.Scanner;

public class CustomStringTrim {

    public static int[] trimUsingCharAt(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start <= end && str.charAt(start) == ' ') {
            start++;
        }
        while (end >= start && str.charAt(end) == ' ') {
            end--;
        }
        return new int[]{start, end};
    }

    public static String substringUsingCharAt(String str, int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i <= end; i++) {
            result.append(str.charAt(i));
        }
        return result.toString();
    }

    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string with spaces: ");
        String input = sc.nextLine();
        int[] indices = trimUsingCharAt(input);
        String customTrimmed = substringUsingCharAt(input, indices[0], indices[1]);
        String builtInTrimmed = input.trim();
        boolean isEqual = compareStrings(customTrimmed, builtInTrimmed);
        System.out.println("Original string: \"" + input + "\"");
        System.out.println("Custom trimmed string: \"" + customTrimmed + "\"");
        System.out.println("Built-in trimmed string: \"" + builtInTrimmed + "\"");
        System.out.println("Are both trimmed strings equal? " + isEqual);
        sc.close();
    }
}