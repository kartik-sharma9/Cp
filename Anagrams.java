import java.util.*;

public class Anagrams {
    public List<Integer> findAnagrams(String s, String p) {
        int lengthofp = p.length();
        if(s.length()<lengthofp)
            return new ArrayList<Integer>();

        char[] countS = new char[256];
        char[] countP = new char[256];


        for(int i=0;i< p.length(); i++){
            countS[s.charAt(i)]++;
            countP[p.charAt(i)]++;
        }
        List list = new ArrayList();
        if(Arrays.equals(countS,countP))
            list.add(0);
        for(int i=1;i< s.length()-lengthofp+1; i++){
            countS[s.charAt(i-1)]--;
            countS[s.charAt(i+lengthofp-1)]++;
            if(Arrays.equals(countS,countP))
                list.add(i);

        }
        return list;
    }

    public static void main(String args[]){
        Anagrams ana = new Anagrams();
        System.out.println(ana.findAnagrams("","a"));
    }
}
