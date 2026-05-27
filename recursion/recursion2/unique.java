package recursion2;

import java.util.HashSet;

public class unique {
    public static void subseq(String str,int idx,String newstr,HashSet<String>set){
        //base case
        if(idx==str.length()){
            if(set.contains(newstr)){
              return;
            }else{
                System.out.println(newstr);
                set.add(newstr);
                return;
            }

        }
        char ch=str.charAt(idx);
        //to be
        subseq(str,idx+1,newstr+ch,set);
        //not to be
        subseq(str,idx+1,newstr,set);
    }

    public static void main(String[] args){
         HashSet<String> set=new HashSet<>();
        String str="aaa";
        subseq(str,0,"",set);
    }
}
