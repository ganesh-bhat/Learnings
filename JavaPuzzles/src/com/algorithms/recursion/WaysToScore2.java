package com.algorithms.recursion;

/*
player can score 3, 5, or 10 points in 1 move. given N, find all of possbile ways
 */
public class WaysToScore2 {


    private static int findWays2(int n) {
        if(n < 0) return 0;
        if(n == 0) return 1;
        return findWays2(n-3) + findWays2(n-5) + findWays2(n-10);
    }


    public static void main(String[] args) {
        System.out.println(findWays2(13));
    }
}
