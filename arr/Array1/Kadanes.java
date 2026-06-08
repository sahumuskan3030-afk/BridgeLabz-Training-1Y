package Array1;

public class Kadanes {

    public static void maxsubarray(int arr[]){
        int n=arr.length;
        int maxsum=Integer.MIN_VALUE;
        int currsum=0;
        for(int st=0;st<n;st++){
            //int currsum=0;
            currsum+=arr[st];
            maxsum=Math.max(currsum,maxsum);
            if(currsum<0){
              currsum=0;
              maxsum=0;
            }
        }
        System.out.println("maximum sum "+maxsum);
    }
    public static void main(String args[]){
        int arr[]={3,-4,5,4,-1,7,-8};
        maxsubarray(arr);
    }
}
