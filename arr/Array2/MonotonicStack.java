package Array2;

import java.util.Stack;

public class MonotonicStack {
    public static void stack(int nums[]){
        Stack<Integer> inc=new Stack<>();
        Stack<Integer> dec=new Stack<>();

        for(int num:nums){
            //monotonic increasing stack
            while(!inc.isEmpty()&&inc.peek()>num){
                inc.pop();
            }
            inc.push(num);

            //monotonic decreasing stack
            while(!dec.isEmpty()&&dec.peek()<num){
                dec.pop();
            }
            dec.push(num);
        }
        System.out.println(inc);
        System.out.println(dec);
    }
    public static void main(String[] args){
      int[] nums={4,2,5,1,3};
      stack(nums);


    }
}
