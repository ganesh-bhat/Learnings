package com.algorithms.arrays;

public class StringToInt {

    public static int stringToInt(String str) {
        int num = 0;

        boolean isNegetive = false;
        int mul = 1;
        if(str.indexOf('-') >= 0) {
            mul = -1;
            isNegetive = true;
        }

        for(int i= str.length()-1;i>=0;i--) {
            if(str.charAt(i)>='0' && str.charAt(i)<='9') {
                num+=(str.charAt(i)-'0')*mul;
                mul*=10;
            }

            if(!isNegetive && num < 0) {
                //went out of range
                return Integer.MAX_VALUE;
            } else if(isNegetive && num > 0) {
                return Integer.MIN_VALUE;
            }

        }
        return num;

    }
}
