package com.algorithms.dp;

/*
find the length of longest substring where sum of first half of the string is same as sum of 2nd half of string
 */
public class LongestSubStringDigitSum {


    public static void main(String[] args) {
        System.out.println(findSubStr("21951421245115"));
    }

    private static int findSubStr(String str) {
        int maxSumStringLen = 0;
        String maxStr = "";
        for(int i=1;i<str.length();i++) {

            //midpoint between i and i-1
            int j = i-1;
            int k = i;

            //expand
            int leftSum = 0;
            int rightSum = 0;

            while(j>=0 && k<str.length()) {
                leftSum +=str.charAt(j)-'0';
                rightSum +=str.charAt(k)-'0';
                j--;
                k++;

                if(leftSum == rightSum) {
                    maxSumStringLen = Math.max(maxSumStringLen, (k-i)*2);
                    if(maxSumStringLen == (k-i)*2) {
                        maxStr = str.substring(j+1,k);
                    }
                }
            }

        }

        System.out.println(maxStr);
        return maxSumStringLen;
    }
}
