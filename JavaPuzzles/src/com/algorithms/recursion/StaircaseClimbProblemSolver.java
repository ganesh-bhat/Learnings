package com.algorithms.recursion;

//Climbing staircase
public class StaircaseClimbProblemSolver {

    public static void main(String[] args) {
        int steps = 5;

        int[] memo = new int[steps+1];
        int ways1 = countClimbWays(steps,memo);
        int ways2 = countClimbWaysDp(steps);
        System.out.println("ways1: "+ways1+",ways2: "+ways2);
    }

    /** recursive */
    public static int countClimbWays(int n, int[] memo) {
        if(n < 0) return 0;
        if(n == 1 || n== 0) return 1;
        if(n == 2) return 2;
        if(n == 3) return 4;

        if(memo[n]>0) return memo[n];

        memo[n] = countClimbWays(n-1, memo) + countClimbWays(n-2,memo) +
                countClimbWays(n-3,memo);

        return memo[n];
    }

    /* dp */
    public static int countClimbWaysDp(int n) {
        if(n<0) return 0;

        int[] memo = new int[n+1];
        memo[1] = 1;
        memo[2] = 2;
        memo[3] = 4;
        if(n < 4) return memo[n];

        for(int i=4;i<=n;i++) {
            memo[i] = memo[i-1] + memo[i-2] + memo[i-3];
        }
        return memo[n];
    }
}

