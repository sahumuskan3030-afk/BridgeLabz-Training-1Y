package Array1;

import java.lang.reflect.Array;
import java.util.Arrays;

public class AddPrefix {
    public static int[]  prefixsum(int arr[]) {
        int n = arr.length;
        int arr1[] = new int[arr.length];
        arr1[0]=arr[0];
        for (int i = 1; i < n; i++) {
            arr1[i] = arr[i] + arr1[i - 1];
        }
        return arr1;
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 5, 7};

        int result[] = prefixsum(arr);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
