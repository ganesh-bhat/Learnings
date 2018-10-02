package com.algorithms.arrays;

import com.Utils;

import java.util.Arrays;

public class DutchFlagSort {



    private static void dutchFlagSort(int[] arr){

        int start = 0;
        int end = arr.length-1;
        int mid = 0;
        int pivot = 1;
        
        while(mid <= end) {
            if(arr[mid] < pivot) { // 1
                Utils.swap(arr, mid, start);
                start++;
                mid++;

            } else if(arr[mid] > pivot) {//2
                Utils.swap(arr, mid, end);
                end--;
            } else { //0
                mid++;
            }

        }
    }



    public static void main(String[] args) {
        int[] arr = {1,2,1,1,2,0,1,2,1,0,0,2,1,1};
        dutchFlagSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
