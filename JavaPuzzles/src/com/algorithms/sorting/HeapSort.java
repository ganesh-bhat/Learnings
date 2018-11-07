package com.algorithms.sorting;

import com.Utils;

import java.util.Arrays;

/*

NOT WORKING!! Find the issue
 */
public class HeapSort {


    private static void heapify(int[] arr, int n,  int i) {

        int left = 2*i+1;
        int right = 2*1+2;
        int largest = i;

        if(left < n && arr[left]>arr[largest]) largest = left;
        if(right < n && arr[right]>arr[largest]) largest = right;

        if(i!=largest) {
            Utils.swap(arr, i, largest);

            heapify(arr, n, largest);
        }
    }

    private static void sort(int[] arr) {

        for(int i=arr.length/2;i>=0;i--) {
            heapify(arr,arr.length-1,i);
        }

        System.out.println(Arrays.toString(arr));

        for(int i=arr.length-1;i>=0;i--) {
            Utils.swap(arr, 0,i);
            heapify(arr,i,0);

        }
    }


    public static void main(String[] args) {

        int[] arr = {5,6,9,1,2,3,4};
        sort(arr);

        System.out.println(Arrays.toString(arr));
    }


}

