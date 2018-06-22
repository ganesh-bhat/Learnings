package com.learning.puzzles.recursion;

/**
 * Created by ganes on 19-05-2018.
 */
public class MathTable {
    public static void main(String[] args) {
        mathTable(9);
        System.out.println("Now recursion");
        recursiveMathTable(9,1);
    }

    static void mathTable(int n) {

        for(int i=1;i<=10;i++) {
            System.out.printf("%d * %d = %d\n",n,i,(n*i));
        }
    }

    static void recursiveMathTable(int n, int i) {
        if(i > 10) {
            return;
        }
        System.out.printf("%d * %d = %d\n", n, i, (n * i));
        recursiveMathTable(n,i+1);
    }

}
