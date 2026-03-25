import java.util.*;
class Age{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the student age");
		int arr[]=new int [10];
		for(int i=0;i<10;i++){
			arr[i]=sc.nextInt();
			if(arr[i]>=18){
				System.out.println("the student can valid for vote");
			}
			else{
				System.out.println("the student cannot valid for vote");
			}
		}
	}
}
		