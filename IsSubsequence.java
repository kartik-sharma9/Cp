public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        char[] small = s.toCharArray();
        char[] big = s.toCharArray();
        int index=0,j=0;
        for(int i=0; i<big.length;i++){
            if(small[j]==big[i]){
                index=i;
                j++;
            }
        }
        if(j==s.length())
            return Boolean.TRUE;
        else
            return Boolean.FALSE;
    }

    public static void main(String args[]){

    }
}
