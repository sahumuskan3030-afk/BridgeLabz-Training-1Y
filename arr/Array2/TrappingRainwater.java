package Array2;

import java.util.Arrays;
import java.util.Stack;

public class TrappingRainwater {
    public static int trap(int[] height){
        int l=0;
        int r=height.length-1;
        int ans=0;
        int lmax=0,rmax=0;
        while(l<r){
            lmax=Math.max(lmax,height[l]);
            rmax=Math.max(rmax,height[r]);
            if(lmax<rmax){
                ans+=(lmax-height[l]);
                l++;
            }else{
                ans+=(rmax-height[r]);
                r--;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int[] height={4,2,0,3,2,5};
        int res=trap(height);
        System.out.println(res);
    }
}
