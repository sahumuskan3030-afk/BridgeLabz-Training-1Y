package Array1;

import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionArray2 {
    public static int[] section(int[] nums1,int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0;
        //using arraylist because we dont know about the size of array
        ArrayList<Integer> list=new ArrayList<>();
        while(i<nums1.length&&j<nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
            //make the size of new array
            int result[]=new int[list.size()];
            for(int k=0;k<list.size();k++){
                result[k]=list.get(k);

        }
        return result;
    }
    public static void main(String[] args){
        int[] nums1={4,9,5,9};
        int[] nums2={9,4,9,8,4};
        int res[]= section(nums1,nums2);
        System.out.println(Arrays.toString(res));
    }
}
