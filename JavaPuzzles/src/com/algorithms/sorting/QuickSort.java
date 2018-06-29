package com.algorithms.sorting;

public class QuickSort {

    public static void sort(Comparable[] array) {
        quickSort(array,0, array.length-1);
    }

    public static void quickSort(Comparable[] array, int left, int right) {
        if(left >= right) {
            return;
        }
        Comparable pivot = array[(left+right)/2];
        int index = partition(array,left,right,pivot);
        quickSort(array,left,index-1);
        quickSort(array,index+1,right);
    }

    private static int partition(Comparable[] array, int left, int right, Comparable pivot) {
        while(left<=right) {
            while(compare(array[left],pivot)<0 ) {
                left++;
            }
            while(compare(array[right],pivot)>0) {
                right--;
            }

            if(left<= right ) {
                swap(array,left,right);
                left++;
                right--;
            }

        }
        return left;
    }

    private static int compare(Comparable elem1, Comparable elem2) {
        if(elem1 == null & elem2 == null) {
            return 0;
        } else if(elem2 ==null) {
            return 1;
        } else if(elem1 == null) {
            return -1;
        }
        return elem1.compareTo(elem2);
    }

    private static void swap(Comparable[] array, int left, int right) {
        Comparable temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

}
