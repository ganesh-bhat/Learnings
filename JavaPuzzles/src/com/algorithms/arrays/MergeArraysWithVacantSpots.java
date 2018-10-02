package com.algorithms.arrays;

import java.util.Arrays;

public class MergeArraysWithVacantSpots {


    public static void main(String[] args) {

        int[] X = {0,2,0,3,0,5,6,0,0};
        int[] Y = {1,8,9,10,15};


        int k=0;
        for(int i=0;i<X.length;i++) {
            if(X[i]!=0) {
                X[k++] = X[i];
            }
        }
        System.out.println(Arrays.toString(X));
        k = k-1;//point to last elem in X
        int j=Y.length-1;
        int i = X.length-1;

        while(k>=0 && j>=0) {
            if(X[k] > Y[j]) {
                X[i--] = X[k--];
            } else {
                X[i--] = Y[j--];
            }
        }

        while(k>=0) {
            X[i--] = X[k--];
        }

        while(j>=0) {
            X[i--] = Y[j--];
        }



        System.out.println(Arrays.toString(X));

    }


}
