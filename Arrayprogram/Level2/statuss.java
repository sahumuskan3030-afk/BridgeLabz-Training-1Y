import java.util.*;
public class statuss{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the no. of person");
		int n=sc.nextInt();
		double weight[]=new double[n];
		double height[]=new double[n];
		double BMI[]=new double[n];
		String status[]=new String[n];
		for(int i=0;i<n;i++){
			System.out.println("enter the weight");
			weight[i]=sc.nextDouble();
			System.out.println("enter the height");
		height[i]=sc.nextDouble();
		
		BMI[i]=weight[i]/(height[i]*height[i]);
		if(BMI[i]<=18.5){
			status[i]="underweight";
		}
		else if(BMI[i]>=18.6&&BMI[i]<=24.9){
			status[i]="normal";
		}
		else if(BMI[i]>=25.0&&BMI[i]<=39.9){
			status[i]="overweight";
		}
		else if(BMI[i]>=40.0){
			status[i]="obese";
		}
		}
		for(int i=0;i<n;i++){
		System.out.println("person"+(i+1)+"    height=" +height[i]+"    weigth=" +weight[i]+"    BMI=" +BMI[i]+"   status="+status[i]);
	}
}
}