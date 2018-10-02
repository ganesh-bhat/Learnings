package com.algorithms.recursion;

public class WaysToScore {

    public static void main(String[] args) {
        System.out.println(waysToScore(13));
    }

    private static int waysToScore(int n) {
        if(n < 0) {
            return 0;
        }

        if(n == 0) {
            return 1;
        }

        return waysToScore(n-10) + waysToScore(n-5) + waysToScore(n-3);
    }
}
