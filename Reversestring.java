
import java.util.*; 
public class Reversestring {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        //creat the scanner object
        System.out.println("enter the name:");
        
        String name=sc.nextLine();
        //read the whole line
       StringBuilder sb=new StringBuilder(name);
       //its a object that a mutable object
       sb.reverse();
       //reverse the string
       System.out.println("reversed string="+sb.toString());
       //print the reversed
       sc.close();
       //close the scanner class
    }
}