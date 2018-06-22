package com.leetcode;

public class RomanToDecimal {


    static char[] NOTATIONS = new char[]{'I','V','X','L', 'C', 'D', 'M'};
    static long[] NOTATIONS_VALS = new long[]{1,5,10,50,100,500,1000};

    public static long romanToDecimal(String roman) {
        /* always large number followed by small number, then its additive
        Small to large is deductive

        MDCCLXXVI
        1000 + 500 + 100 + 100 + 50 + 10+10+5+1

        MCMLIV
        1000+(1000-100)+50+(5-1)

        MIIIL
        1047

       */

     /*
     for each char
        check next,
            if prev is larger, then its additive, just add current number to sum and proceed
            if prev is smaller,
                start travelling back doing localSum of numbers and remove from sum, once you find bigger number
                also deduct localSum from the current number and add formed number to sum
     * */
        long totalSum = 0;
        long prev = Long.MAX_VALUE;
        for(int i=0;i<roman.length();i++) {
            char romanChar = roman.charAt(i);
            long num = getNumber(romanChar);
            if(prev>=num) {
                totalSum+=num;
            } else {
                //start looking back and compute local sum
                long localSum = 0;
                long localPrev = Long.MAX_VALUE;
                for(int j=i-1;j>=0;j--) {
                    char localRomanChar = roman.charAt(j);
                    long localNum = getNumber(localRomanChar);
                    if(localPrev>=localNum) {
                        localSum+=localNum;
                    } else {
                        break;
                    }
                    localPrev = localNum;
                }
                totalSum=totalSum-localSum;
                num=num-localSum;
                totalSum+=num;
            }
            prev = num;
        }

        return totalSum;
    }

    private static long getNumber(char romanChar) {
        for(int i=0;i<NOTATIONS.length;i++) {
            if(NOTATIONS[i] == romanChar) {
                return NOTATIONS_VALS[i];
            }
        }
        return 0;
    }

}
