import java.util.*;
class frequency{
	public static void main(String args[]){
		//use the scanner class to user input
		Scanner sc=new Scanner(System.in);
		//input the no. by user
		System.out.println("enter the no.");
		//long data type uses for store the long no.
		long n=sc.nextLong();
		//put the size of a array
		int fre[]=new int[10];
		//check the condition greater than the no.
        while(n>0){
			//take a digit by the initialize of digit
			int digit=(int)(n%10);
			//increament in position of digit
			fre[digit]++;
			//store the quentient
			n=n/10;
		}
		//for loop to run in the array
		for(int i=0;i<10;i++){
			//chek the condition not give output of 0 
			if(fre[i]>0){
				print the output by line by line
			System.out.println("digit"+i+"="+fre[i]);
			}
		}
	}
}