package com.algorithms.recursion;

public class PlacePiece {

    private static int waysToPlace(int len) {

        if(len <= 0) {
            return 0;
        }
        if(len == 1) {
            return 1;
        }
        if(len == 2) {
            return 2;
        }

        return waysToPlace(len-1) + waysToPlace(len-2);


    }

    public static void main(String[] args) {
       int res = waysToPlace(5);
        System.out.println(res);
    }
}
