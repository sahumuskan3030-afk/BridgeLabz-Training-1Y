import java.util.*;
public class substr{
static String subUsingCharAt(String s,int start,int end){
String sub ="";
for(int i=start;i<end;i++){
sub+=s.charAt(i);
}
return sub;
}
public static void main(String args[]){
Scanner s = new Scanner(System.in);
String str = s.next();
int start = s.nextInt();
int end = s.nextInt();
String sub1 = subUsingCharAt(str,start,end);
String sub2 = str.substring(start,end);
System.out.println("charAt(): " + sub1);
System.out.println("substring(): " + sub2);

}
}