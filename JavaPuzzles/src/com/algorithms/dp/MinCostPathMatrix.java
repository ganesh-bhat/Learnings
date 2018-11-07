package com.algorithms.dp;

import java.util.Arrays;

public class MinCostPathMatrix {

    public static void main(String[] args) {
        int[][] cost = {
                {1,3,5,8},
                {4,2,1,7},
                {4,3,2,3}
        };
        int totalCost =  findLowCostPath(cost, 2,3);
        System.out.println(totalCost);
    }

    private static int findLowCostPath(int[][] cost, int x, int y) {
        int[][] minCost = new int[cost.length][cost[0].length];

        int curCost = 0;
        for(int i=0;i<cost[0].length;i++) {
            curCost+=cost[0][i];
            minCost[0][i] = curCost;
        }

        curCost = 0;
        for(int i=0;i<cost.length;i++) {
            curCost+=cost[i][0];
            minCost[i][0] = curCost;
        }

        for(int i=1;i<cost.length;i++) {
            for(int j=1;j<cost[0].length;j++) {

                int computedCost = Integer.MAX_VALUE;
                if(minCost[i-1][j]!=0 && minCost[i][j-1]!=0) {
                    computedCost = Math.min(minCost[i-1][j],minCost[i][j-1]) + cost[i][j];
                } else if(minCost[i-1][j] == 0) {
                    computedCost = minCost[i][j-1] + cost[i][j];
                } else {
                    computedCost = minCost[i-1][j] + cost[i][j];
                }

                if(computedCost > minCost[i][j] && minCost[i][j]!=0) {
                    minCost[i][j] = computedCost;
                } else if(minCost[i][j] == 0) {
                    minCost[i][j] = computedCost;
                }

            }
        }


        //System.out.println(Arrays.deepToString(minCost).replaceAll("\\],","]\n"));

        return minCost[x][y];
    }
}
