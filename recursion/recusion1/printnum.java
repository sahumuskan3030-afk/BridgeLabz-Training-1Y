package recusion1;

/*public class printnum {
    public static void printn(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        printn(n-1);
    }

    public static void main(String args[]){
        int n=5;
        printn(n);
    }
}*/


public class printnum{
    public static void printn(int n){
        if(n==5){
            return;
        }
        System.out.println(n);
        printn(n+1);
    }
    public static void main(String args[]){
       int n=1;
       printn(n);
    }
}
