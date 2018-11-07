package com.algorithms.recursion;

public class Knapsack_01 {

    public static void main(String[] args) {
        int[] value = {20,5,10,40,15,25};
        int[] weight = {1,2,3,8,7,4};
        int W = 10;//knapscak weight

        int maxValue = knapSack(value,weight,W, value.length-1);
        System.out.println(maxValue);


    }

    private static int knapSack(int[] v, int[] w, int W, int n) {
        if(W == 0 || n < 0) {
            //found items adding upto weight
            return 0;
        }
        if(W < 0 ) {
            return Integer.MIN_VALUE;
        }

        //inclue
        int value1 = v[n]+ knapSack(v,w, W-w[n],  n-1);
        //exclude
        int value2 = knapSack(v,w, W, n-1);

        return Math.max(value1,value2);
    }
}
