package Array1;
import java.util.*;
import java.util.HashSet;

public class IntersectionArray {
    public static int[] intersection(int[] nums1,int[] nums2){
        HashSet<Integer> set1=new HashSet<>();
        HashSet<Integer> result=new HashSet<>();

        for(int num:nums1){
            set1.add(num);
        }

        for(int num:nums2){
            if(set1.contains(num)){
                result.add(num);
            }
        }
        int nums[]=new int[result.size()];
        int i=0;
        for(int num:result){
            nums[i++]=num;
        }
        return nums;
    }


    public static void main(String[] args){
        int[] nums1={1,2,2,1};
        int[] nums2={2,2};
        int[] result= intersection(nums1,nums2);
        System.out.println(Arrays.toString(result));
    }
}
