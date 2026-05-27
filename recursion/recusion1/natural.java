package recusion1;

public class natural {
    public static void naturalsum(int i,int n, int sum){
        if(i==n){
            sum+=i;
            System.out.println(sum);
            return;
        }
        sum+=i;
        //System.out.println(sum);
        naturalsum(i+1,n,sum);
    }
    public static void main(String args[]){

    naturalsum(1,5,0);
    }
}
