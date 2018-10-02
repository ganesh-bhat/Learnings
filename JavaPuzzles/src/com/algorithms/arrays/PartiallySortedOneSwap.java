package com.algorithms.arrays;

import com.Utils;

import java.util.Arrays;

public class PartiallySortedOneSwap {

    public static void main(String[] args) {
       // int[] arr = {3,8,6,7,5,9};
       // int[] arr = {3,5,7,6,8,9};
        int[] arr = {3,5,6,9,8,7};

        int prev = -1;
        int cur = -1;
        int next = -1;

        int m = -1;
        int n = -1;
        for(int i=0;i<arr.length;i++) {
            prev = cur;
            cur = arr[i];
            if(i+1 < arr.length) {
                next = arr[i+1];
            }
            if(cur < prev || cur > next) {
                if(m == -1) {
                    m = i;
                } else {
                    //last occurance of conflict
                    n = i;
                }
            }
        }

        System.out.println(m+","+n);
        Utils.swap(arr, m, n);
        System.out.println(Arrays.toString(arr));

    }
}
