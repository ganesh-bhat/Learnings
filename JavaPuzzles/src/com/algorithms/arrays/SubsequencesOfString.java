package com.algorithms.arrays;

/**
 * Two ways to generate subsequence of a string.
 */
public class SubsequencesOfString {

    public static void printSubsequences(String s) {
        subSequence(s,"",0);

    }

    /** simple recursion approach */
    private static void subSequence(String in, String out, int i) {
        if(i >= in.length()) {
            System.out.print(out+",");
            return;
        }
        subSequence(in, out+in.charAt(i),i+1);
        subSequence(in, out,i+1);
    }


    /**
     * Description on how it works based on tree approach.
     * https://www.youtube.com/watch?v=0TVDNGLGXYg
     *
     * @param in
     */
    public static void nAryPermute(String in) {
        char[] arr = new char[in.length()];
        for(int i=0;i<arr.length;i++) {
            nAryPermuteHelper(in,i,arr,0);
        }
    }
    private static void nAryPermuteHelper(String in, int idx, char[] out, int pi) {
        if(idx >= in.length()) {
            return;
        }
        out[pi] = in.charAt(idx);
        System.out.print(String.copyValueOf(out,0,pi+1)+",");

        for(int i=idx+1;i<in.length();i++) {
            nAryPermuteHelper(in,i,out,pi+1);
        }
    }

    public static void main(String[] args) {
        /* this includes and excludes and prints when end state reached */
        printSubsequences("ABC");
        System.out.println();
        /* this approach buils the string step by step */
        nAryPermute("ABC");
    }

}
