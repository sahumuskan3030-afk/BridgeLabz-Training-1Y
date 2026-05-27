package recusion1;

/*public class stack {
    public static int height(int x,int n){
        if(n==0) return 1;
        if(x==0) return 0;
        int h=height(x,n-1);
       // int pow=Math.pow(x,h);
        int p=x*h;
        return p;
    }
    public static void main(String args[]){
        System.out.println(height(5,2));
    }
}*/

public class stack{
    public static int calcpow(int x,int n){
        if(n==0) return 1;
        if(x==0) return 0;
        if(n%2==0) return calcpow(x,n/2)*calcpow(x,n/2);
        else
            return calcpow(x,n/2)*calcpow(x,n/2)*x;
    }
    public static void main(String[] args){
        int x=2,n=5;
        int ans=calcpow(x,n);
        System.out.println(ans);

    }
}
