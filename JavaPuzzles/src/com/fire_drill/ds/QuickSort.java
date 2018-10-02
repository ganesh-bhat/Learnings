package com.fire_drill.ds;

import java.util.Arrays;

public class QuickSort {


    public static void main(String[] args) {
        Integer[] arr = {5,8,1,2,3,6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static<T extends Comparable> void sort(T[] arr) {
        quickSort(arr, 0,arr.length-1);

    }

    private static<T extends Comparable> void quickSort(T[] arr, int left, int right) {
        if(left>=right) return;

        T pivot = arr[(left+right)/2];
        int index = partition(arr,left,right,pivot);
        quickSort(arr, left, index-1);
        quickSort(arr, index, right);
    }

    private static<T extends Comparable> int partition(T[] arr,int left, int right, T pivot) {
        while(left<=right) {
            while(pivot.compareTo(arr[left])>0) {
                left++;
            }

            while(pivot.compareTo(arr[right])<0) {
                right --;
            }


            if(left<=right) {
                T temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return left;


    }



}
