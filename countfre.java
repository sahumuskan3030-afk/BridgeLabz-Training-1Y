import java.util.*;
public class countfre {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String name=sc.nextLine();
        int count =0;
        StringBuilder sb=new StringBuilder(name);
        for(int i=0;i<name.length();i++){
            count++;
        }
        System.out.println("total no. of frequency="+count);
        sc.close();
    }
    
}
