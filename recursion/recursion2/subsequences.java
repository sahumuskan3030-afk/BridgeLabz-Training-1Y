package recursion2;

public class subsequences {
    public static void subseq(String str,int idx,String newstr){
        //base case
        if(idx==str.length()){
            System.out.println(newstr);
            return;
        }
        char ch=str.charAt(idx);
        //to be
        subseq(str,idx+1,newstr+ch);
        //not to be
        subseq(str,idx+1,newstr);
    }

    public static void main(String[] args){
        String str="aaa";
        subseq(str,0,"");
    }
}
