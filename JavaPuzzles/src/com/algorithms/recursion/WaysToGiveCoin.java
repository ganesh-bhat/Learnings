package com.algorithms.recursion;

public class WaysToGiveCoin {

    private static int findCoinsNeeded(int[] denominations,
                                       int n, int total) {
        if(total == 0 ) return 1;
        if(total < 0 || n<0 ) return 0;

        int include = findCoinsNeeded(denominations, n, total-denominations[n]);
        int exclude = findCoinsNeeded(denominations, n-1, total);

        return include+exclude;
    }


    public static void main(String[] args) {
        int[] denominations = {1,5,10,20};
        int total = 10;
        int coins = findCoinsNeeded(denominations, denominations.length-1, total);
        System.out.println(coins);
    }


}
