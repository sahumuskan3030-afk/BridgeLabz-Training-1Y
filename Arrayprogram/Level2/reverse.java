import java.util.*;
class reverse{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the no.");
		int n=sc.nextInt();
		int count=0;
		int temp=n;
		while(temp!=0){
			count++;
			temp=temp/10;
		}
		int i=0;
		temp=n;
		int nums[]=new int[count];
		while(temp!=0){
			nums[i]=temp%10;
			temp=temp/10;
			i++;
		}
		for( i=0;i<nums.length;i++){
		System.out.print(nums[i]);
		}
		
	}
}	
		