package Array1;

import java.util.Arrays;

public class MajorityElement {
    public static int majority(int arr[]){
        Arrays.sort(arr);
        int count=0;
        int n=arr.length;
        for(int i=0;i<n;i++) {
            if (arr[i] == arr[i + 1]) {
                count++;
            }
            if (count > n / 2) {
                return arr[i];
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int arr[]={1,2,2,5,4,2,2};
        //Arrays.sort(arr);
        System.out.println(majority(arr));
       // System.out.println(arr);
    }

}
