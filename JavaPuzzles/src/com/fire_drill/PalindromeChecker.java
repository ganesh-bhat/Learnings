package com.fire_drill;

public class PalindromeChecker {
    public boolean isPalindrome(String input) {
        if(input == null || input.isEmpty() ) return true;

        int len = input.length();
        for(int i=0;i<len/2;i++){
            if(input.charAt(i) != input.charAt(len-1-i)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args){
        PalindromeChecker paliChecker = new PalindromeChecker();
        System.out.println(paliChecker.isPalindrome("abccba"));
        System.out.println(paliChecker.isPalindrome("abcdba"));
        System.out.println(paliChecker.isPalindrome("a"));
        System.out.println(paliChecker.isPalindrome(""));
        System.out.println(paliChecker.isPalindrome("ssssssssssssssssssssssssssssssssssssssssssss"));
    }


}
