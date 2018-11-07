package com.algorithms.recursion;

/**
 * Recursion with memoization
 * also look at DP solution at DP package
 */
public class MinCostPathMatrix {


    public static void main(String[] args) {
        int[][] cost = {
            {1,3,5,8},
            {4,2,1,7},
            {4,3,2,3}
        };

        int[][] memo = new int[cost.length][cost[0].length];

      int totalCost =  findLowCostPath(cost, 2,3, memo);
        System.out.println(totalCost);
    }

    private static int findLowCostPath(int[][] cost, int x, int y, int[][] memo) {
        if(x< 0 || y < 0) {
            //no low cost path
            return Integer.MAX_VALUE;
        }

        if(memo[x][y] != 0) {
            //already exists
            return memo[x][y];
        }

        if(x == 0 && y == 0) {
            //reached
            return cost[0][0];
        }

        int best = Integer.MAX_VALUE;
        if(x == 0) {
            best = findLowCostPath(cost, x, y-1,memo)+ cost[x][y];
        } else if(y ==0) {
            best = findLowCostPath(cost, x-1, y, memo)+ cost[x][y];
        } else {
            int rightMoveCost = findLowCostPath(cost, x-1, y, memo);
            int bottomMoveCost = findLowCostPath(cost, x, y-1,memo);
            best = Math.min(rightMoveCost,bottomMoveCost) + cost[x][y];
        }
        memo[x][y] = best;
        return best;
    }
}
