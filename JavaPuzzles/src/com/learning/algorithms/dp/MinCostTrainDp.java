package com.learning.algorithms.dp;

/**
 * Created by ganes on 19-05-2018.
 */
public class MinCostTrainDp {

    public static void main(String[] args) {

        int[][] cost = {
                {0,10,75,94,100},
                {-1,0,35,50,80},
                {-1,-1,0,80,100},
                {-1,-1,-1,0,110},
                {-1,-1,-1,-1,0},
        };

        System.out.println(calcCost(cost, 0, 4));

    }

    static int calcCost(int[][] costs, int s, int d) {
        int[] minCost = new int[costs.length];

        if(s<0||d<0) {
            return 0;
        }

        if(s == d || s == d-1) {
            return costs[s][d];
        }

        minCost[0] =  0;
        minCost[1] = costs[0][1];

        for(int i=2;i<=d;i++) {
            minCost[i] = costs[0][i];

            for(int j=1; j<i;j++) {

                if(minCost[i] > (minCost[j]+costs[i][j])) {
                    minCost[i] = minCost[j]+costs[i][j];
                }
            }

        }

      return minCost[d];
    }
}
