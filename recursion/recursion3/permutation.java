package recursion3;

public class permutation {
    public static void printperm(String str,String permutation){
        //base case
        if(str.length()==0){
            System.out.println(permutation);
            return;
        }
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            String newstr=str.substring(0,i)+str.substring(i+1);
            printperm(newstr,permutation+ch);
        }
    }
    public static void main(String[] args){
        String str="abc";
        printperm(str,"");
    }
}
