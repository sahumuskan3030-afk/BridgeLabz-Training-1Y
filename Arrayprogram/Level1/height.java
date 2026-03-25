import java.util.*;
class height{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the height of players");
		//double height=sc.nextDouble();
		double height[]=new double[11];
		int sum=0;
		for(int i=0;i<11;i++){
			height[i]=sc.nextDouble();
			sum+=height[i];
		}
		System.out.println("the mean height of players="+sum/11);
		sc.close();
	}
}