package recursion2;

public class occurance {
    public static int first=-1;
    public static int last=-1;
    public static void occur(int idx, String str,char element){
        //base case
        if(idx==str.length()){
            System.out.println(first);
            System.out.println(last);
            return;
        }
       char currelement=str.charAt(idx);
       if(currelement==element){
           if(first==-1){
               first=idx;
           }else{
               last=idx;
           }
       }
       occur(idx+1,str,element);
    }
    public static void main(String args[]){
     String str="abaacdaefaah";
     occur(0,str,'a');
    }
}
