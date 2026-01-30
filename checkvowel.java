import java.util.*;
//import the user scanner class
public class checkvowel {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        //scanner object for user input
        String name=sc.nextLine();
        //store the name and read the whole line
        int vowelcount=0;
        int consonantcount=0;
        //initialation
        StringBuilder sb=new StringBuilder(name);
        //store the original string and it is mutable
        for(int i=0;i<name.length();i++){
            //for loop iteration the loop
            if(name.charAt(i)=='a'||name.charAt(i)=='e'||name.charAt(i)=='i'||name.charAt(i)=='0'||name.charAt(i)=='u'){
                //check the condition
                vowelcount++;
                //count the variablfe
            }
            
            else{
                consonantcount++;
            }
        }
        //print the vowel and consonant
        System.out.println("no of vowel="+vowelcount);
        System.out.println("no of consonant="+consonantcount);
        sc.close();

    }
}
