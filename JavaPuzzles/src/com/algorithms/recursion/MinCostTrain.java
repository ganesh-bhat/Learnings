package com.algorithms.recursion;

/**
 * Created by ganes on 19-05-2018.
 */
public class MinCostTrain {

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

        if(s<0||d<0) {
            return 0;
        }

        if(s == d || s == d-1) {
            return costs[s][d];
        }

        int minCost =  costs[s][d];

        for(int i=s+1;i<d;i++) {
            int temp =   calcCost(costs, s, i) +  calcCost(costs, i, d);
            if(temp < minCost) {
                minCost = temp;
            }
        }
      return minCost;
    }
}
