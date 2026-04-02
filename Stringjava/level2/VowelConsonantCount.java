import java.util.Scanner;

class VowelConsonantCount {

    // Method to check vowel or consonant
    static int[] countVC(String str) {
        int vowels = 0, consonants = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // Convert uppercase to lowercase using ASCII
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char)(ch + 32);
            }

            // Check if letter
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                    vowels++;
                else
                    consonants++;
            }
        }

        return new int[]{vowels, consonants};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String str = sc.nextLine();

        int[] result = countVC(str);

        System.out.println("Vowels: " + result[0]);
        System.out.println("Consonants: " + result[1]);
    }
}