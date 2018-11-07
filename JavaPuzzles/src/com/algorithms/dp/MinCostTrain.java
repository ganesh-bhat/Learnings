package com.algorithms.dp;

/**
    uses dynamic programming instead of recursion
 */
public class MinCostTrain {

    public static void main(String[] args) {
        int[][] cost = {
                {0,10,75,94},
                {-1,0,35,50},
                {-1,-1,0,80},
                {-1,-1,-1,0}
        };
        int[][] memo = new int[cost.length][cost.length];

        int out = findMinDistance(cost, memo, 0,3);
        System.out.println(out);
    }

    private static int findMinDistance(int[][] cost, int[][] memo, int start, int end) {
        //known fact, current to next is known, current to current is known (0)
        for(int i=0;i<memo.length;i++) {
            for(int j=0;j<memo.length;j++) {
                memo[i][j] = cost[i][j];
            }
        }


        int minCost = memo[start][end];
        for(int i=start+1;i<end;i++) {
             minCost= Math.min(minCost, memo[start][i] + memo[i][end]);
        }
        memo[start][end] = minCost;

        return memo[start][end];
    }

}
