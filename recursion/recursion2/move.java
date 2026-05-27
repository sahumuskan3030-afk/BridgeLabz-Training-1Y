package recursion2;

public class move {
    public static void moveelement(int idx,int count, String str, String newstr){
        if(idx== str.length()) {
            for (int i = 0; i < count; i++) {
                newstr += 'x';
            }
                System.out.println(newstr);
                return;
            }
        char ch= str.charAt(idx);
        if (ch != 'x') {
            newstr+=ch;
        }else{
            count++;
        }
      moveelement(idx+1,count,str,newstr);
    }
    public static void main(String args[]){
        String str="axbcxxd";
        moveelement(0,0,str,"");
    }
}
