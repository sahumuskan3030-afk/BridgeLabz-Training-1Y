import java.util.Scanner;

public class ArgumentExceptionDemo {

    // Method to generate IllegalArgumentException
    public static void generateException(String text) {
        // start index > end index
        System.out.println("Substring: " + text.substring(5, 2));
    }

    // Method to handle IllegalArgumentException
    public static void handleException(String text) {
        try {
            // start index > end index
            System.out.println("Substring: " + text.substring(5, 2));
        } 
        catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: " + e);
            System.out.println("Start index cannot be greater than end index.");
        } 
        catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter a string: ");
        String input = sc.next();

        // Step 1: Generate the exception (Program will stop here)
        System.out.println("\nGenerating IllegalArgumentException:");
        generateException(input);

        // Step 2: Handle the exception
        System.out.println("\nHandling IllegalArgumentException:");
        handleException(input);

        sc.close();
    }
}
