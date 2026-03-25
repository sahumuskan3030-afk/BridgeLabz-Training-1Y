import java.util.*;
class youngest{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String name[]={"Amar","Akbar","Anthony"};
        int age[]=new int[3];
        double height[]=new double[3];
        for(int i=0;i<3;i++){
            System.out.println("enter the detail="+name[i]);
            System.out.println("enter the age");
            age[i]=sc.nextInt();
            System.out.println("enter the height");
            height[i]=sc.nextDouble();
            System.out.println();
        }
        int youngindex=0;
        int tallindex=0;
        for(int i=1;i<3;i++){
            if(age[i]<age[youngindex]){
                youngindex=i;
            }
            if(height[i]>height[tallindex]){
                tallindex=i;
            }
            System.out.println("the youngest="+name[youngindex]);
            System.out.println("the tallest="+name[tallindex]);
        }
        sc.close();
    }
}