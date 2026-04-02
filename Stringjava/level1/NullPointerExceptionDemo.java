public class NullPointerExceptionDemo {

    // Method to generate NullPointerException
    public static void generateException() {
        String text = null;

        // This will generate NullPointerException
        System.out.println("Length of string: " + text.length());
    }

    // Method to handle NullPointerException using try-catch
    public static void handleException() {
        String text = null;

        try {
            System.out.println("Length of string: " + text.length());
        } catch (NullPointerException e) {
            System.out.println("Exception caught: " + e);
            System.out.println("Cannot call methods on a null reference.");
        }
    }

    public static void main(String[] args) {

        
        System.out.println("Generating NullPointerException:");
        generateException();

        
        System.out.println("\nHandling NullPointerException:");
        handleException();
    }
}
