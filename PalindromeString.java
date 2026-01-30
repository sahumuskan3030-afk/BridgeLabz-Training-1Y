import java.util.*;
//scanner class to import user
public class PalindromeString {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        //user input use scanner class
        String name=sc.next();
        //input the name from user
        StringBuilder sb=new StringBuilder(name);
        //stringbuilder object to store the original string 
        sb.reverse();
        //original string reverse
        if(name.equals(sb.toString())){
            //check the condition
            System.out.println("the name is palindrome="+name);
            //if it true print the name
        }
        else{
            System.out.println("the name is not a palindrome");
        }
        sc.close();
        //close the scanner class
    }
}
