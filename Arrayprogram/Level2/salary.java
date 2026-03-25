import java.util.*;
class salary{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		double salary ,bonous,newsalary=0.0,oldsalary=0.0;
		double total_bonous=0.0;

		for(int i=0;i<10;i++){
			
			int year=sc.nextInt();
			salary=sc.nextDouble();
			if(year>5){
				bonous=salary*0.05;
			}
			else {
				bonous=salary*0.02;
			}
			total_bonous+=bonous;
			oldsalary+=salary;
			newsalary+=salary+bonous;
		}
		System.out.println("Total bonous= "+total_bonous);
		System.out.println(" Total old salary"+oldsalary);
		System.out.println(" Total new salary"+newsalary);
		sc.close();
	}
}
			