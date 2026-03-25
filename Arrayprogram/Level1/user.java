import java.util.*;
class user{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
			System.out.println("enter the 5 number");
			int arr[]=new int[5];
			for(int i=0;i<5;i++){
				arr[i]=sc.nextInt();
				if(arr[i]>0){
					System.out.println("the number is positive");
				}
				else if(arr[i]<0){
					System.out.println("the number is negative");
				}
				else{
					System.out.println("the number is zero");
				}
			}
			if(arr[0]==arr[4]){
				System.out.println("the number is equal");
			}
			else if(arr[0]>arr[4]){
				System.out.println("the number is greater");
			}
			else{
				System.out.println("the number is leser");
				}
			}
		}
