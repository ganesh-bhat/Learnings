package com.algorithms.recursion;

public class MinCoins {
    private static int findCoinsNeeded(int[] denominations,
                                       int total, int[] mem) {

        if(total == 0 ) return 0;
        if(total < 0 ) return Integer.MAX_VALUE;
        if(mem[total]>0) return mem[total];

        int minCoins = Integer.MAX_VALUE;
        for(int d:denominations) {
            int coins = findCoinsNeeded(denominations, total-d,mem);
            if(coins!=Integer.MAX_VALUE)
                minCoins = Math.min(coins+1, minCoins);
        }
        mem[total] = minCoins;
        return minCoins;

    }


    public static void main(String[] args) {
        int[] d = {1,5,10,20};
        int total = 1152;
        int[] mem = new int[total+1];
        int coins = findCoinsNeeded(d, total,mem);
        System.out.println(coins);
    }

}

