package com.algorithms.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MissingNumFinder {

    public static int findMissingNumber(int[] array, int n){
        int num = array.length;
        int sum = 0;
        for(int i=0;i<num;i++) {
            sum+=array[i];
        }
        return (n*(n+1))/2 - sum;
    }

    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
