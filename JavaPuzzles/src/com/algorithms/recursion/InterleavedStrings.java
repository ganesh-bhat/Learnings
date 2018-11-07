package com.algorithms.recursion;

/**
 * C said to be interleaving if it contains all chars of A and B and relative order preserved
 */
public class InterleavedStrings {

    public static void main(String[] args) {
       boolean interleaved = isInterleaved("xyz","abcd","xabyczd");
        System.out.println("interleaved:"+interleaved);
    }

    private static boolean isInterleaved(String a, String b, String c) {
        if(c.length() == 0 && ( a.length()>0 || b.length()> 0)) {
            return false;
        }
        if(c.length() ==0 && a.length() == 0 &&  b.length() ==0) {
            return true;
        }

        char firstChar = c.charAt(0);
        if(a.indexOf(firstChar) >= 0) {
            return isInterleaved(a.substring(a.indexOf(firstChar)+1),b,c.substring(1));
        } else if(b.indexOf(firstChar) >= 0) {
            return isInterleaved(a, b.substring(b.indexOf(firstChar)+1),c.substring(1));
        } else {
            return false;
        }
    }
}
