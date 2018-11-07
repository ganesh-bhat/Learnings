package com.algorithms.arrays;

import java.util.Arrays;

/**
 * http://www.techiedelight.com/rearrange-the-array-with-alternate-high-and-low-elements/
 */
public class HighLowElemes {


    private static void highLowElems(int[] arr) {
        for(int i=1;i<arr.length;i+=2) {
            if(arr[i+1] > arr[i]) {
                swap(arr, i, i+1);
            }

            if(arr[i-1] > arr[i]) {
                swap(arr, i, i-1);
            }

        }
    }

    private static void swap(int[] arr, int i1, int i2) {
        if(i2 < arr.length && i1< arr.length) {
            int temp = arr[i1];
            arr[i1] = arr[i2];
            arr[i2] = temp;
        }
    }


    public static void main(String[] args) {

        int[] arr = {2,5,3,6,18,9,7,11,15,8,1};
        highLowElems(arr);

        System.out.println(Arrays.toString(arr));
    }
}
