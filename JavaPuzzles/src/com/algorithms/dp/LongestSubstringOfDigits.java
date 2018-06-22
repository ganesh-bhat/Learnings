package com.algorithms.dp;

/**
 * Created by ganes on 20-05-2018.
 *
 * //brute force
 */
public class LongestSubstringOfDigits {
    public static void main(String[] args) {
      System.out.println(longest("142124"));

      //  System.out.println(Character.digit('5',10));
    }


    static int longest(String str) {
        int maxLen = 0;
        for(int i=0;i<str.length();i++) {//start index
            for(int j=i+1;j<str.length();j+=2) {//end index
                int len = (j-i+1);

                if(maxLen >=len) {
                    continue;
                }

                int lSum = 0;
                int rSum = 0;
                for(int k=0;k<len/2;k++) {
                    lSum += Character.digit(str.charAt(i+k),10);
                    rSum += Character.digit(str.charAt(i+k+len/2),10);
                }
               // System.out.println(lSum+","+rSum);
                if(lSum == rSum) {
                    maxLen =  len;
                }
            }
        }
        return maxLen;
    }


}
