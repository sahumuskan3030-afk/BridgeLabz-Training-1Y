package Array1;
import java.util.*;
public class Rotate {
    public static void rotatearray(int arr[],int k){
        int n=arr.length;

        //handle the k greater than array size
        k=k%n;

        //step1: reverse the entire array
        reverse(arr,0,n-1);

        //step2: reverse first k element
        reverse(arr,0,k-1);

        //step3: reverse remaining element
        reverse(arr,k,n-1);
    }
    public static void reverse(int arr[],int start,int end){
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;

            start++;
            end--;
        }
    }
    public static void main(String args[]){
        int arr[]={1,2,3,4,5,6,7};
       // int k=9;
        rotatearray(arr,3);
        System.out.println(Arrays.toString(arr));
    }
}
