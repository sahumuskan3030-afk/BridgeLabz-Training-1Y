import java.util.*;
public class level{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the no.");
		int n=sc.nextInt();
		double physics[]=new double[n];
		double chemistry[]=new double[n];
		double maths[]=new double[n];
		double percentage[]=new double[n];
		String grade[]=new String[n];
		for(int i=0;i<n;i++){
			System.out.println("enter the marks of"+(i+1));
			System.out.println("enter the marks of physics");
			physics[i]=sc.nextDouble();
			if(physics[i]<0){
				System.out.println("invailed maks");
				continue;
			}
			System.out.println("enter the marks of chemistry");
			chemistry[i]=sc.nextDouble();
			if(chemistry[i]<0){
				System.out.println("invailed marks");
				continue;
			}
			System.out.println("enter the marks of maths");
			maths[i]=sc.nextDouble();
			if(maths[i]<0){
				System.out.println("invailed marks");
				continue;
			}
		
		percentage[i]=(physics[i]+chemistry[i]+maths[i])/3;
		
		if(percentage[i]>=80)
			grade[i]="A";
		else if(percentage[i]>=70)
			grade[i]="B";
		else if(percentage[i]>=60)
			grade[i]="C";
		else if(percentage[i]>=50)
			grade[i]="D";
		else if(percentage[i]>=40)
			grade[i]="E";
		else 
			grade[i]="R";
	}
	System.out.println("result");
	for(int i=0;i<n;i++){
		System.out.println("student"+(i+1));
		System.out.println("physics"+physics[i]);
		System.out.println("chemistry"+chemistry[i]);
		System.out.println("maths"+maths[i]);
		System.out.println("percentage"+percentage[i]+"%");
		System.out.println("grade"+grade[i]);
		System.out.println();
	}
	sc.close();
}
}
