package recursion3;

public class pairs {
    public static int invite(int n){
        //base case
        if(n<=1){
            return 1;
        }
        //single
        int single=invite(n-1);
        //pair
        int pair=(n-1)*invite(n-2);
        return single+pair;

    }
    public static void main(String args[]){
        int n=4;
        System.out.println(invite(n));
    }
}
