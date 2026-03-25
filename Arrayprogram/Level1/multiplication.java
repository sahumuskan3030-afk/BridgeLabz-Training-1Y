import java.util.*;
class multiplication{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
        System.out.println("enter the number");
		int num=sc.nextInt();
		System.out.println("multiplication table="+num+":");
		for(int i=6;i<=9;i++){
			System.out.println(num+"*"+i+"="+(num*i));
		}
		sc.close();
	}
}