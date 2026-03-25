import java.util.*;
public class twoDarray{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the no. of person");
		int n=sc.nextInt();
		double persondata[][]=new double[n][3];
		String [] weightstatus=new String[n];
		for(int i=0;i<n;i++){
			System.out.println("person"+(i+1));
			do{
				System.out.print("enter height(in meter):");
				persondata[i][0]=sc.nextDouble();
			}
			while(persondata[i][0]<=0);
				do{
					System.out.print("enter wight(in kg):");
					persondata[i][1]=sc.nextDouble();
				}while(persondata[i][1]<=0);
				persondata[i][2]=persondata[i][1]/(persondata[i][0]*persondata[i][0]);
				if(persondata[i][2]<18.5)
					weightstatus[i]="underweight";
				else if(persondata[i][2]<25)
					weightstatus[i]="normal";
				else if(persondata[i][2]<30)
					weightstatus[i]="overweight";
				else
					weightstatus[i]="obese";
		}
		System.out.println("result");
		for(int i=0;i<n;i++){
			System.out.println("person"+(i+1));
			System.out.println("height:"+persondata[i][0]);
			System.out.println("weight:"+persondata[i][0]);
			System.out.println("BMI:"+persondata[i][2]);
			System.out.println("status:"+weightstatus[i]);
			System.out.println();
		}
		sc.close();
	}
}