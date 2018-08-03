package com.algorithms.permutationCombination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * m choose n problems
 *
 *  total count = n!/ (m! * ( n-m)!)
 *
 */
public class CombinationGenerator {

    public static int count(int[] nums, int m) {
        return factorial(nums.length)/ ( factorial(m) * factorial(nums.length-m));
    }

    private static int factorial(int x) {
        int res = 1;
        for(int i=2;i<=x;i++) {
            res*=i;
        }
        return res;
    }

    public static int count2(int n, int m, int p) {
        int[] memo = new int[m+1];
        memo[0] = 1;
        //nCr = f(n-1,m) + f(n-1, m-1)
        for(int i=0;i<n;i++) {
            for(int j=Math.min(i,m);i>0;j--) {
                memo[j] = (memo[j]+memo[j-1])%p;
            }
        }
        return memo[m];

    }


    /* method 1*/
    public static void choose(int[] nums, int m) {
        int[] result = new int[m];
        choose(result,0,0, nums,m);
    }

    /* method 1 using for loop */
    public static void choose(int[] result, int resIndex, int start,  int[] nums, int m) {
        if(m == resIndex ) {
           System.out.println(Arrays.toString(result));
            return;
        }

        for(int i=start;i<nums.length;i++) {
            result[resIndex] = nums[i];//fix one elem
            //pick all possible combination for next elem
            choose(result,resIndex+1, i+1, nums, m);
        }
    }


    /* method 2 */
    public static void choose2(int[] nums, int m) {
        int[] result = new int[m];
        choose2(result,0,0, nums,m);
    }

    /* method 2 using include exclude elements */
    public static void choose2(int[] result, int resIndex, int index,  int[] nums, int m) {
        if(m == resIndex ) {
            System.out.println(Arrays.toString(result));
            return;
        }

        //pick all possible combination for next elem
        result[resIndex] = nums[index];
        choose(result,resIndex+1, index+1, nums, m);
        choose(result,resIndex, index+1, nums, m);
    }


}
