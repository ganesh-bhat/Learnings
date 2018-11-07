package com.algorithms.dp;

import java.util.Arrays;

public class PalindromeSubStringDp {
/*

    public static int findLongestPalindromeDp(String input) {
        int n = input.length();
        int[][] table = new int[n][n];
        for(int i=0;i<input.length();i++) {
            table[i][i] = 1; //each char is palindrome of len 1
        }

        for(int k=2;k<=n;k++) {

            for(int i=0;i<n-k+1;i++) {
                int j = i+k-1;
                if(input.charAt(i) == input.charAt(j) && k == 2) {
                    table[i][j] = 2;
                } else if(input.charAt(i) == input.charAt(j) ){
                    table[i][j] = table[i+1][j-1]  + 2;
                }  else {
                    table[i][j] = Math.max(table[i+1][j]  , table[i][j-1]);
                }
            }

        }

        return table[0][n-1];
    }


*/
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

    private static int findLongestPalindromeDp(String input) {
        int n = input.length();
        int[][] table = new int[n+1][n+1];

        for(int i=0;i<n;i++) {
            Arrays.fill(table[i],0);
        }

        for(int i=0;i<n;i++) {
            table[i][i] = 1;
        }

        for(int i=1;i<n;i++) {
            for(int j=n-1;j<=0;j--) {
                //changed i & j in table to +1, so that we can use 0,0 index
                if(input.charAt(i) == input.charAt(j)) {
                    table[i][j] = 2 + table[i+1][j-1];
                } else {
                    table[i][j] = Math.max(table[i+1][j],table[i][j-1]);
                }
            }
        }
        return table[n][n];
    }



    public static void main(String[] args) {
        int res = findLongestPalindromeDp("aBACd");
        System.out.println(res);
    }
}
