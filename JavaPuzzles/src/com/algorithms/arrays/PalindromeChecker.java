package com.algorithms.arrays;

import java.util.*;
import java.util.regex.*;
import java.lang.*;
import java.io.*;

/**
 * Palindrome with special chars passed, one should count only alphanumerics
 */
public class PalindromeChecker {

    static Pattern pattern = Pattern.compile("[A-Za-z0-9]");
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();
        sc.nextLine();
        for(int f=0;f<testCases;f++) {
            String str= sc.nextLine();
            if(checkPalindrome(str)){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean checkPalindrome(String str) {
        int len = str.length();
        int left=0;
        int right = len-1;

        boolean isPalindrome = true;
        while(left<=right) {

            if(!isValid(str.charAt(left))){
                left++;
                continue;
            }

            if(!isValid(str.charAt(right))){
                right--;
                continue;
            }

            if(Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        return isPalindrome;

    }

    private static boolean isValid(char c) {
        return pattern.matcher(String.valueOf(c)).matches();
    }
}
