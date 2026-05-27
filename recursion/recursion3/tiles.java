package recursion3;

public class tiles {
    public static int floor(int n,int m){
       if(n==m){
           return 2;
       }
       if(n<m){
           return 1;
       }
        //vertical place
        int verticalplace_tiles=floor(n-m,m);
        //horizontal
        int horizontal=floor(n-1,m);
        return verticalplace_tiles+horizontal;
    }
    public static void main(String[] args){
      int n=4,m=2;
        System.out.println(floor(n,m));
    }
}
