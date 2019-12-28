package com.company;

import java.util.HashMap;
import java.util.Map;

class HighestLengthSubsquenceWIthoutRepitition {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int max=0;
        int currentLength=0;
        int startIndex=0,index=0;
        int endIndex=0;
        char[] arr = s.toCharArray();
        for(char i: arr){
            if(map.containsKey(i)){
                max = endIndex-startIndex>max?endIndex-startIndex:max;
                startIndex= startIndex>map.get(i)+1?startIndex:map.get(i)+1;
                map.remove(i);
                map.put(i,index);
                endIndex++;
            }
            else{
                map.put(i,index);
            	endIndex++;
            	
            }
            index++;
        }
        max = endIndex-startIndex>max?endIndex-startIndex:max;
        return max;
    }
    public static void main(String args[]){
        HighestLengthSubsquenceWIthoutRepitition obj= new HighestLengthSubsquenceWIthoutRepitition();
        System.out.println(obj.lengthOfLongestSubstring("abba"));
    }
}