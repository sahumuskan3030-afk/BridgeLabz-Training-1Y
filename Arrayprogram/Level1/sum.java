import java.util.*;
class sum{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the element");
		double arr[]=new double [10];
		double total_sum=0.0;
		int index=sc.nextInt();
		while(index<=0){
			System.out.println("the number is invalid");
			break;
		}
		for(int i=0;i<10;i++){
			arr[i]=sc.nextInt();
			total_sum+=arr[i];
		}
		System.out.println("the total sum ="+total_sum);
	}
}
		