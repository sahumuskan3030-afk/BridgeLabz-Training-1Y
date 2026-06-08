package Array1;


import java.util.Arrays;

public class LongestPrefix {
    public static String Prefix(String[] strs){
        Arrays.sort(strs);
        //to apply stringbuilder form for mutable
        StringBuilder result=new StringBuilder();

        char[] first=strs[0].toCharArray();
        char[] last=strs[strs.length-1].toCharArray();

        for(int i=0;i<first.length;i++){
            if(first[i]!=last[i]){
                break;
            }
            result.append(first[i]);
        }
        return result.toString();
    }

    public static void main(String[] args){
        String[] strs={"clone","clove","cloud"};
        System.out.println(Arrays.toString(strs));
        String ans=Prefix(strs);
        System.out.println(ans);
    }
}
