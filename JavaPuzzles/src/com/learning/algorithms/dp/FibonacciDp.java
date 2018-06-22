package com.learning.algorithms.dp;

/**
 * Created by ganes on 20-05-2018.
 */
public class FibonacciDp {
    public static void main(String[] args) {
        System.out.println(fibonacci(13));
    }

    static int fibonacci(int n) {
        int[] fib = new int[n+1];
        fib[1] = 1;
        fib[2] = 1;

        for(int i=3;i<=n;i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }

        return fib[n];

    }
}
