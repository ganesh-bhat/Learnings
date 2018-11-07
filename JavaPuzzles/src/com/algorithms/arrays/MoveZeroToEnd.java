package com.algorithms.arrays;

import com.Utils;

import java.util.Arrays;

public class MoveZeroToEnd {

    private static void moveZeros(int[] arr) {

        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            while(arr[high] == 0) {
                high --;
            }
            if(arr[low] == 0) {
                Utils.swap(arr, low, high);
                high--;
            }
            low++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0,101,0,1,0,4,6,6,7,0,4};
        moveZeros(arr);
        System.out.println(Arrays.toString(arr));
    }
}
