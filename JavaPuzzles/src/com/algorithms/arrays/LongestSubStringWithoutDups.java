package com.algorithms.arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutDups {

    public static int findOptimal(String str) {

        int i=0;
        int max = 0;

        //initialized to 0
        int[] offset = new int[128];
        for(int j=0;j<str.length();j++) {
            i = Math.max(i, offset[str.charAt(j)]); //avoids the check to if it contains
            max = Math.max(max,j-i+1);//window size
            offset[str.charAt(j)] = j+1;// offset to contain how many moves i should make
        }
        return max;
    }

    public static int find1(String str) {

        int i=0;
        int max = 0;

        Map<Character,Integer> offsetMap = new HashMap<>();
        for(int j=0;j<str.length();j++) {
            if(offsetMap.containsKey(str.charAt(j))) {
                i = Math.max(i, offsetMap.get(str.charAt(j)));
            } else {
                max =  Math.max(max, j-i+1);
            }
            offsetMap.put(str.charAt(j), j+1);
        }

        return max;

    }


}
