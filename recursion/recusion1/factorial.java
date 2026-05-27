package recusion1;

public class factorial {
    public static int  fact(int n ){
        if(n==1){
            return 1;
        }
        int fact_num= fact(n-1);
        int fact_n=fact_num*n;
        return (fact_n);
    }
    public static void main(String args[]){
        System.out.println(fact(5));
    }
}
