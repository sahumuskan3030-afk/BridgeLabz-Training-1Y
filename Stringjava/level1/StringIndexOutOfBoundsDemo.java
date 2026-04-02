import java.util.Scanner;


public class StringIndexOutOfBoundsDemo {

    // Method to generate StringIndexOutOfBoundsException
    public static void generateException(String text) {
        // Accessing index beyond string length
        System.out.println("Character at invalid index: " + text.charAt(text.length()));
    }

    // Method to handle StringIndexOutOfBoundsException
    public static void handleException(String text) {
        try {
            // Accessing index beyond string length
            System.out.println("Character at invalid index: " + text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception caught: " + e);
            System.out.println("Invalid index! Index should be between 0 and " + (text.length() - 1));
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter a string: ");
        String input = sc.next();

        // Step 1: Generate the exception (Program will stop here)
        System.out.println("\nGenerating StringIndexOutOfBoundsException:");
        generateException(input);

        // Step 2: Handle the exception
        System.out.println("\nHandling StringIndexOutOfBoundsException:");
        handleException(input);

        sc.close();
    }
}
 