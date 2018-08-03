package com.algorithms.recursion;

/*
https://practice.geeksforgeeks.org/problems/count-of-strings-that-can-be-formed-using-a-b-and-c-under-given-constraints/0
 */
public class FindNumStringsPermutation {

    public static int countStringsWithConstraints(int n) {
        return countStringsWithConstraints("", n,1,2);
    }

    private static int countStringsWithConstraints(String str, int n, int remainB, int remainC) {
        if(n == 0) {
            System.out.println(str);
            return 1;
        }

        int total = 0;
        //top level 3 nodes, a, b, c
        total+=countStringsWithConstraints(str+"a", n-1, remainB, remainC);
        if(remainB>0) {
            total+=countStringsWithConstraints(str+"b", n-1, remainB-1, remainC);
        }
        if(remainC >0) {
            total+=countStringsWithConstraints(str+"c", n-1, remainB, remainC-1);
        }
        return total;
    }



}
