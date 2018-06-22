package com.puzzles;

import java.util.Arrays;

public class ArraySum {


    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        sum(array,0);
        System.out.println(Arrays.toString(array));
    }

    private static void sum(int[] arr, int index) {
        if(index == arr.length || index < 0) {
            return;
        }
        if(index > 0) {
            arr[index] = arr[index] + arr[index-1];
        }
        sum(arr, index+1);
    }
}
