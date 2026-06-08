package Array2;

import java.util.Arrays;

public class SquareArray {
    public static int[] sorted(int[] arr){
        int[] sum=new int[arr.length];
        int l=0;
        int r=arr.length-1;
        int idx=arr.length-1;
        while(l<r) {
            int left_square=arr[l]*arr[l];
           int right_square=arr[r]*arr[r];
           if(left_square<right_square){
               sum[idx]=right_square;
               r--;
           }else{
               sum[idx]=left_square;
               l++;
           }
           idx--;
        }

        return (sum);
    }
    public static void main (String[] args){
        int[] arr={-7,-4,-1,-3,3,6,10};
       int[] result= (sorted(arr));
        System.out.println(Arrays.toString(result));
    }
}
