package com.algorithms.recursion;

/**
 * Created by ganes on 19-05-2018.
 */
public class Fibonacci {

    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(recFib(13));
        long end = System.nanoTime();
        System.out.println("Time taken:"+(end-start));

        System.out.println(fib(15));
    }

    static int[] memo = new int[150];
    static int recFib(int n) {
        if( n == 1 || n == 2) {
            return 1;
        }
        if(memo[n]!=0) {
            return memo[n];
        }
        memo[n] =  recFib(n-1) + recFib(n - 2);
        return memo[n];
    }

    static int fib(int n) {
        int a = 1;
        int b = 1;
        int temp = 0;

        for(int i=3;i<=n;i++) {
            temp = a+b;
            a = b;
            b = temp;
        }

        return b;

    }
}
