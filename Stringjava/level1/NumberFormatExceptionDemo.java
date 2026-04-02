import java.util.Scanner;

public class NumberFormatExceptionDemo {

    // Method to generate NumberFormatException
    public static void generateException(String text) {
        // This will throw NumberFormatException if text is not a valid number
        int number = Integer.parseInt(text);
        System.out.println("Converted number: " + number);
    }

    // Method to handle NumberFormatException
    public static void handleException(String text) {
        try {
            int number = Integer.parseInt(text);
            System.out.println("Converted number: " + number);
        } 
        catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: " + e);
            System.out.println("Input text is not a valid integer.");
        } 
        catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking user input as String
        System.out.print("Enter a number: ");
        String input = sc.next();

        // Step 1: Generate the exception (Program may stop here)
        System.out.println("\nGenerating NumberFormatException:");
        generateException(input);

        // Step 2: Handle the exception
        System.out.println("\nHandling NumberFormatException:");
        handleException(input);

        sc.close();
    }
}
