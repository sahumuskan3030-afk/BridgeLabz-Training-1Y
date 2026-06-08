package Array1;

import java.util.*;
public class BinarySearch {
    public static int search(int arr[],int target) {

        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                 l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {-1, 0, 3, 5, 9, 12,-2,3};
        Arrays.sort(arr);
       int result= search(arr,3);
       if(result!=-1){
           System.out.println("element found at index "+result);
       }else{
           System.out.println("element not found at index");
       }
    }
}
