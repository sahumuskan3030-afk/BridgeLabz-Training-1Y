import java.util.*;
class fizzbuzz{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter the number");
		int n=sc.nextInt();
		if(n<=0){
			System.out.println("please enter the positive no.");
			break;
		}
		int arr[]=new int[n];
		for(int i=0;i<n;i++){
		if(i%3==0){
			System.out.println(position[i]=fizz);
		}
		else if(i%5==0){
          System.out.println(position[i]=buzz);
		}
		else if(i%3==0&&i%5==0){
			System.out.println(position[i]=fizzbuzz);
		}
		else{
			System.out.println(position[i]=i);
	    }
       }
	   sc.close();
    }
}