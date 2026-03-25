import java.util.*;
class multi{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the number for which multiple");
		int num=sc.nextInt();
		int arr[]=new int [10];
		int multiple=1;
				  System.out.println("Multiplication Table of"+num+":");
		for(int i=1;i<=10;i++){
		  System.out.println(num+"*"+i+"="+(num*i));
		}
		sc.close();
	}
}