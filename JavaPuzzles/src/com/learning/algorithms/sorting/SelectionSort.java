package com.learning.algorithms.sorting;

import java.util.Arrays;

/**
 * Stable sorting - O(n^2) complexity
 * When you're doing something quick and dirty and for some reason you can't just use the standard library's sorting algorithm.
 * The only advantage these have over insertion sort is being slightly easier to implement.
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] numbers = {4,6,1,2,5,8,9,7};

        selectionSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    private static void selectionSort(int[] array) {
        int start = 0;
        while(start < array.length-1) {
            int minPos = getMinElemPosition(array,start);
            swap(array, start,minPos);
            start++;
        }

    }

    private static int getMinElemPosition(int[] array, int start) {
        int min = array[start];
        int minPos = start;
        for(int i=start+1;i<array.length;i++) {
            if(array[i]<min) {
                min = array[i];
                minPos = i;
            }
        }
        return minPos;
    }

    private static void swap(int[] array, int p1, int p2) {
        int temp = array[p1];
        array[p1] = array[p2];
        array[p2] = temp;
    }


}
