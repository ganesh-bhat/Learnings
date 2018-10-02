package com.algorithms.recursion;

import java.util.Arrays;

/**
 * Memoized solution for mincost
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
        if(start+1 == end || start == end) {
            //only one hop
            return cost[start][end];
        }

        int minCost = cost[start][end];
        if(memo[start][end]== 0) {
            for(int i=start+1;i<end;i++) {
                minCost = Math.min(minCost, findMinDistance(cost,memo, start, i) + findMinDistance(cost,memo, i, end));
            }
            memo[start][end] = minCost;
        }

        return memo[start][end];

    }

}
