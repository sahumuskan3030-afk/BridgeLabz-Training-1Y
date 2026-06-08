package Array1;
import java.util.*;
public class MergeTwoArray {
    public static void main(String args[]){
        int arr2[]={1,2,3,4};
        int arr1[]={5,2,7,8};
        int merge[]=new int[arr1.length+arr2.length];

        for(int i=0;i<arr1.length;i++){
            merge[i]=arr1[i];
        }
        for(int i=0;i<arr2.length;i++){
            merge[arr1.length+i]=arr2[i];
        }
        System.out.println(Arrays.toString(merge));
    }
}
