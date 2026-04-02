import java.util.Scanner;

public class ArrayIndexDemo {

    // Generate exception without handling
    static void generateException(String[] arr) {
        System.out.println(arr[arr.length + 1]); // causes exception
    }

    // Handle exception with try-catch
    static void handleException(String[] arr) {
        try {
            System.out.println(arr[arr.length + 1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of names: ");
        String[] names = new String[sc.nextInt()];
        sc.nextLine();
        for (int i = 0; i < names.length; i++) names[i] = sc.nextLine();

        try { generateException(names); } catch (Exception e) {}
        handleException(names);
        sc.close();
    }
}
