package recursion2;

public class reverse {
    public static void printrev(int idx, String str){
        if(idx==0){
            System.out.println(str.charAt(idx));
            return;
        }
        System.out.print(str.charAt(idx));
        printrev(idx-1,str);

    }
    public static void main(String args[]){
        String str="abcd";
        printrev(str.length()-1,str);

    }
}
