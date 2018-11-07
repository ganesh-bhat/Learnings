package com.algorithms.recursion;

public class PalindromeSubString {


    public static int findLongestPalindrome(String input, int start, int end) {
        if(start > end ) return 0;
        if(start == end ) return 1;

        if(input.charAt(start) == input.charAt(end)) {
            //remove both and
            return 2+findLongestPalindrome(input,start+1, end-1);
        } else {
            return Math.max( findLongestPalindrome(input,start+1, end),
                    findLongestPalindrome(input,start, end-1));
        }
    }

    public static int findLongestPalindrome(String input) {
        return findLongestPalindrome(input,0,input.length()-1);
    }

    public static void main(String[] args) {
        int res = findLongestPalindrome("yuiQWERTYuYTREWQbnm");
        System.out.println(res);
    }

}
