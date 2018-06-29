package com.algorithms.arrays;

public class LongestPalindromeSubString {

    public static void main(String[] args) {
        String palindromeSuper = "adefabcfddfcbahmla";

        int j = palindromeSuper.length()-1;
        int k = 0;

        int start = -1;
        int end = -1;
        boolean foundPali = true;
        for(int i=0;i<palindromeSuper.length();i++) {
            start = -1;
            end = -1;
            k = i;
            j = palindromeSuper.length()-1;
            while(k<j) {
                if(start == -1) {
                    start = k;
                    end = j;
                }
                if(palindromeSuper.charAt(k) == palindromeSuper.charAt(j)) {
                    k++;
                    foundPali = true;
                } else {
                    foundPali = false;
                }
                j--;
            }
            if(foundPali && j == k) {
                System.out.println("Found start:"+start+",end:"+end);
            }


        }


    }
}
