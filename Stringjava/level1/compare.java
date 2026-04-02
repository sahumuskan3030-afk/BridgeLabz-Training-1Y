import java.util.*;
public class compare{
	private static boolean
	compareString(String str1,String str2){
			if(str1.length()!=str2.length()){
			return false;
		}
		for(int i=0;i<str1.length();i++){
				if(str1.charAt(i)!=str2.charAt(i)){
					return false;
				}
			}
			return true;
	}

	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the str1");
		String str1=sc.next();
		System.out.println("enter the str2");
		String str2=sc.next();
         boolean result1=compareString(str1,str2);
		 boolean result2=str1.equals(str2);
		 System.out.println("using charAt():"+result1);
		 System.out.println("using charAt():"+result2);
		 if(result1==result2){
			 System.out.println("both result are same");
		 }
			 else{
				 System.out.println("result are different");
			 }
	sc.close();
	}

}

		