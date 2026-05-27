package recusion1;

public class fibonacci {
    public static void fibo(int a,int b,int c,int n){
        if(n==7){
            return;
        }
        System.out.println(c);
        fibo(b,c,b+c,n+1);
    }
    public static void main(String args[]){
        int a=0;
        int b=1;
        System.out.println(a);
        System.out.println(b);
        fibo(0,1,a+b,1);
    }
}
