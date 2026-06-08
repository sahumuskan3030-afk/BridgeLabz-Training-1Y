package Array2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {
    public static int[] greater(int[] nums1,int[] nums2) {
        int[] result = new int[nums1.length];
        //stack m monotonic value store karne k liya
        Stack<Integer> stack = new Stack<>();
        //map m value store karne k liya
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums2) {
            while (!stack.empty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
            //remaining element
            while (!stack.isEmpty()) {
                map.put(stack.pop(), -1);
            }

            for (int i = 0; i < nums1.length; i++) {
                result[i] = map.get(nums1[i]);
            }
            return result;
        }
    public static void main(String[] args){
        int[] nums1={4,1,2};
        int[] nums2={1,3,4,2};
        System.out.println(Arrays.toString(greater(nums1,nums2)));
    }
}
