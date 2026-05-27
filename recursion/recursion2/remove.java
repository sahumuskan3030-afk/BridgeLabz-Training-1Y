package recursion2;

public class remove {
    public static boolean[] map=new boolean[26];
    public static void removedupli(String str,int idx,String newstr) {
        if(idx==str.length()){
            System.out.println(newstr);
            return;
        }
        char ch = str.charAt(idx);
        if (map[ch - 'a']) {
            removedupli(str, idx + 1, newstr);
        } else {
            newstr += ch;
            map[ch - 'a'] = true;
            removedupli(str, idx + 1, newstr);
        }
    }
    public static void main(String[] args){
        String str="abbcda";
        removedupli(str,0,"");

    }
}
