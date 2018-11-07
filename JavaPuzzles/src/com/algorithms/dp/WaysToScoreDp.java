package com.algorithms.dp;

public class WaysToScoreDp {

    private static int waysToScore(int n) {
        int[] tbl = new int[n+1];

        tbl[0] = 1;

        for(int i=1;i<=n;i++) {
            int counts = 0;
            if(i-3>=0) counts += tbl[i-3];
            if(i-5>=0)counts+= tbl[i-5];
            if(i-10>=0) counts+= tbl[i-10];

            tbl[i] += counts;
        }

        return tbl[n];

    }

    public static void main(String[] args) {
        System.out.println(waysToScore(13));
    }
}
