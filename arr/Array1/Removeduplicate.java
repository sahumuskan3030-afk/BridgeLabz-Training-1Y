package Array1;

import java.util.HashSet;

public class Removeduplicate {

    public static void main(String[] args){
        HashSet<Integer> set=new HashSet<>();
        int arr[]={1,2,3,3,4,1};
        for(int num:arr){
            set.add(num);
        }
        System.out.println(set);
    }
}
