package com.algorithms.arrays;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {

        int end = 0;
        boolean isMismatch = false;
       for(int i=0;i<strs[0].length();i++) {
           char c = 0 ;
           end = i;
           for(String str:strs) {
               if(c == 0) {
                   c = str.charAt(i);
               } else if(str.length()<= i || c != str.charAt(i)) {
                   isMismatch = true;
               }
           }
           if(isMismatch) break;

       }

       if(isMismatch) {
           return strs[0].substring(0,end);
       } else {
           return strs[0].substring(0,end+1);
       }


    }
}
