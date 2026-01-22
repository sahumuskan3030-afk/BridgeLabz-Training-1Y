import java.util.Scanner;
class PerimeterSquare{
	public static void main(String[] args){
		Scanner sc=new Scanner (System.in);
		System.out.println("enter the side perimeter");
		int side=sc.nextInt();
		int Perimeter=4*side;
		System.out.println("perimeter of square="+Perimeter);
	}
}