import java.util.Scanner;

 public class ShortestLongest {
    
    static int len(String s) {
        int i = 0;
        try {
            while (true) {
                s.charAt(i);
                i++;
            }
        } catch (Exception e) {}
        return i;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter sentence:");
        String str = sc.nextLine();

        String word = "", shortest = "", longest = "";
        int min = 999, max = 0;

        for (int i = 0; i <= len(str); i++) {
            if (i == len(str) || str.charAt(i) == ' ') {
                
                int l = len(word);

                if (l > 0) {
                    if (l < min) {
                        min = l;
                        shortest = word;
                    }
                    if (l > max) {
                        max = l;
                        longest = word;
                    }
                }
                word = "";
            } else {
                word += str.charAt(i);
            }
        }

        System.out.println("Shortest Word: " + shortest);
        System.out.println("Longest Word: " + longest);
    }
}