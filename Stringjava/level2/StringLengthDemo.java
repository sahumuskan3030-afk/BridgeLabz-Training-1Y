import java.util.Scanner;

public class StringLengthDemo {

    // Method to find string length without using length()
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count); // access character at index
                count++;           // increment count
            }
        } catch (IndexOutOfBoundsException e) {
            // When index exceeds, exception occurs, return count
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();

        // Find length using user-defined method
        int manualLength = findLength(input);

        // Find length using built-in method
        int builtinLength = input.length();

        // Display results
        System.out.println("Length using user-defined method: " + manualLength);
        System.out.println("Length using built-in length(): " + builtinLength);

        sc.close();
    }
}
