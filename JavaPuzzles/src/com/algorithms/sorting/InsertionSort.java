package com.algorithms.sorting;

import java.util.Arrays;

/**
 * When N guaranteed to be small - O(N^2) , best is O(N)
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] numbers = {4,6,1,2,5,8,9,7};

        insertSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    private static void insertSort(int[] array) {
        for(int i=1;i<array.length;i++) {
            int j=i;
            while(j>0 && (array[j-1] > array[j]) ) {
                swap(array, j, j-1);
                j = j-1;
            }
        }
    }

    private static void swap(int[] array, int j, int i) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
