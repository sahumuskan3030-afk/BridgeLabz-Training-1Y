import java.util.*;
class slargest{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the size of array");
		int n=sc.nextInt();
		int arr[]=new int[n];
		System.out.println("enter the digit");
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		int max=arr[0];
		for(int i=0;i<n;i++){
			if(arr[i]>max){
				max=arr[i];
			}
		}
		int smax=arr[0];
		for(int i=0;i<n;i++){
			if(arr[i]>smax&&arr[i]!=max){
				smax=arr[i];
			}
		}
		
		System.out.println(max);

		System.out.println(smax);
		sc.close();
	}
}