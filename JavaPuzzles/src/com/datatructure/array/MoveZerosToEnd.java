package com.datatructure.array;

import java.util.Arrays;

public class MoveZerosToEnd {

    private static void moveZerosToEnd(int[] arr) {
        for(int i=0;i<arr.length;i++) {
            if(arr[i] == 0) {
               System.arraycopy(arr,i+1,arr,i,arr.length-1-i);
               arr[arr.length-1] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,0,3,0,4,0,6};
        moveZerosToEnd(arr);
        System.out.println(Arrays.toString(arr));
    }
}
