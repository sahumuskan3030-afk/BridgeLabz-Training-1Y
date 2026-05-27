package recursion3;

public class path {
    public static int  movepaths(int i,int j,int n,int m){
      //base case
        if(i==n||j==m){
            return 0;
        }
        if(i==n-1&&j==m-1){

            return 1;
        }
    //move downward
        int downward=movepaths(i+1,j,n,m);

        //move right
        int rightpaths=movepaths(i,j+1,n,m);
        return  downward+rightpaths;
    }
    public static void main(String args[]){
     int n=3,m=3;
        System.out.println( movepaths(0,0,n,m));

    }
}
