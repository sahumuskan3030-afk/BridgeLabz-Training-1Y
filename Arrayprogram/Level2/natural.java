import java.util.*;
class natural{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the size of array");
		int size=sc.nextInt();
		int []odd=new int[size];
		int []even=new int [size];
		int evenindex=0;
		int oddindex=0;
		for(int i=0;i<size;i++){
			if(i%2==0){
				even[evenindex]=i;
				evenindex++;
			}
			else{
				odd[oddindex]=i;
				oddindex++;
			}
		}
		//print th even number
		System.out.println("the array is even");
		for(int i=0;i<evenindex;i++){
			System.out.print(" "+even[i]);
		}
		System.out.println();
		System.out.println("the array is odd");
		for(int i=0;i<oddindex;i++){
			System.out.print(" "+odd[i]);
		}
		sc.close();

	}
}