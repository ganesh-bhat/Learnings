package com.algorithms.arrays;

public class StringZigZag {


    public static String zigZag(String str, int numRows) {
        if(numRows==1) return str;

        StringBuilder[] sbs = new StringBuilder[numRows];
        for(int i=0;i<sbs.length;i++) {
            sbs[i] = new StringBuilder();
        }

        int row = 0;
        boolean isForward = true;
        for(int i=0;i<str.length();i++) {
            sbs[row].append(str.charAt(i));
            row = isForward?  row+1:row-1;
            if(row == numRows) {//hits end
                isForward = false;
                row-=2;
            } else if(row < 0) {
                isForward = true;
                row+=2;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<sbs.length;i++) {
           sb.append(sbs[i]);
        }
        return  sb.toString();
    }
}
