import java.util.*;
class student{
    String name;
    int id;
    
    void display_detalis(){
        System.out.println("Your name: "+name);
        System.out.println("Your id: "+id);
    }
    
}
public class Main{
    static Scanner sc=new Scanner(System.in);
    public static void main(String[]args){
        
        
        
        student s1=new student();
        System.out.println("Enter your name: ");
        s1.name=sc.nextLine();
        System.out.println("Enter your id: ");

        s1.id=sc.nextInt();
        
        s1.display_detalis();
    }
}
