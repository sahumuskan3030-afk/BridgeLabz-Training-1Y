import java.util.Scanner;

public class StringCharacterComparison {

    // Method to return characters of string without using toCharArray()
    public static char[] getCharacters(String text) {
        char[] result = new char[text.length()];
        
        for (int i = 0; i < text.length(); i++) {
            result[i] = text.charAt(i);
        }
        
        return result;
    }

    // Method to compare two character arrays
    public static boolean compareArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter a string: ");
        String input = sc.next();

        // Using user-defined method
        char[] userMethodResult = getCharacters(input);

        // Using built-in method
        char[] builtInResult = input.toCharArray();

        // Comparing both arrays
        boolean isSame = compareArrays(userMethodResult, builtInResult);

        // Display results
        System.out.println("\nCharacters using user-defined method:");
        for (char c : userMethodResult) {
            System.out.print(c + " ");
        }

        System.out.println("\n\nCharacters using built-in toCharArray() method:");
        for (char c : builtInResult) {
            System.out.print(c + " ");
        }

        System.out.println("\n\nAre both arrays equal? " + isSame);

        sc.close();
    }
}
