package Array2;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {
    public static int[] temperature(int[] temp){
        int[] result=new int[temp.length];
        //stack use to store indices
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<temp.length;i++){
            while(!stack.empty()&&temp[stack.peek()]<temp[i]){
                int idx=stack.pop();
                result[idx]=i-idx;
            }
            stack.push(i);
        }
        return result;
    }
    public static void main(String[] args){
        int temp[]={73,74,75,71,69,72,76,73};
        int[] result=temperature(temp);
        System.out.println(Arrays.toString(result));
    }
}
