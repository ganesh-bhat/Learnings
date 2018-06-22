package com.learning.puzzles.generic;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by ganes on 20-06-2018.
 * https://www.youtube.com/watch?v=zKwwjAkaXLI
 */
public class SubsetSumDynamic<K> {


    // Returns true if there is a subset of
    // set[] with sun equal to given sum
    static boolean isSubsetSum(int set[],
                               int n, int sum)
    {
        boolean[][] subset = new boolean[n+1][sum+1];

        for(int i=0;i<=n;i++) {
            subset[i][0] = true;
        }

        for(int j=1;j<=sum;j++) {
            subset[0][j] = false;
        }

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=sum;j++) {

                subset[i][j] = subset[i-1][j];
                if(j >= set[i- 1]) {
                    subset[i][j] = subset[i-1][j] || subset[i-1][j-set[i-1]];
                }
            }
        }

        return subset[n][sum];
    }

    /* Driver program to test above function */
    public static void main (String args[])
    {
        int set[] = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        int n = set.length;
        if (isSubsetSum(set, n, sum) == true)
            System.out.println("Found a subset"
                    + " with given sum");
        else
            System.out.println("No subset with"
                    + " given sum");
    }
}