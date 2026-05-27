package recursion2;

public class towerofHanoi {
    public static void tower(int n,String src, String helper, String dest){
        //base case
        if(n==1) {
            System.out.println("transfer disk" + n + "from" + src + "to" + dest);
            return;
        }
        tower(n-1,src,dest,helper);
        System.out.println("transfer disk "+n+" from "+src+" to "+dest);
        tower(n-1,helper,src,dest);
    }
    public static void main(String args[]){
        int n=3;
        tower(n,"S","H","D");
    }

}
