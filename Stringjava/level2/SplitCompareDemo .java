import java.util.Scanner;

public class SplitCompareDemo {

    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {}
        return count;
    }

    public static String[] splitText(String text) {
        int len = findLength(text);
        int wordCount = 1;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') wordCount++;
        }

        int[] spaceIndexes = new int[wordCount - 1];
        int idx = 0;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') spaceIndexes[idx++] = i;
        }

        String[] words = new String[wordCount];
        int start = 0;
        for (int i = 0; i < wordCount; i++) {
            int end = (i < wordCount - 1) ? spaceIndexes[i] : len;
            StringBuilder word = new StringBuilder();
            for (int j = start; j < end; j++) word.append(text.charAt(j));
            words[i] = word.toString();
            start = end + 1;
        }

        return words;
    }

    public static boolean compareStringArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] manualWords = splitText(input);
        String[] builtinWords = input.split(" ");
        boolean match = compareStringArrays(manualWords, builtinWords);

        for (String word : manualWords) System.out.println(word);
        System.out.println();
        for (String word : builtinWords) System.out.println(word);
        System.out.println("\nDo both split results match? " + match);
        sc.close();
    }
}
