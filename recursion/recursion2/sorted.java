package recursion2;

public class sorted {
    public static boolean strictlyinc(int arr[],int idx){
      if(arr[idx]==arr.length-1){
          return true;
      }
      if(arr[idx]<arr[idx+1]){
          return strictlyinc(arr,idx+1);
      }else {
          return false;
      }
      //strictlyinc(arr,idx+1);
    }
    public static void main(String[] args){
     int arr[]={1,2,3,6};
        System.out.println(strictlyinc(arr,0));
    }
}
