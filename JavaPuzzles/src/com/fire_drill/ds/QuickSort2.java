package com.fire_drill.ds;

import java.util.Arrays;

public class QuickSort2 {

    public static void main(String[] args) {
        Integer[] arr = {5,8,1,5,2,2,3,6,3,3,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(Comparable[] arr) {
        quickSort(arr,0,arr.length-1);
    }

    private static void quickSort(Comparable[] arr, int left, int right) {
        if(left>=right) return;

        Comparable pivot = arr[(left+right)/2];
        int index = partition(arr,left,right,pivot);
        quickSort(arr,left, index-1);
        quickSort(arr,index, right);
    }

    private static int partition(Comparable[] arr, int left, int right, Comparable pivot) {

        while(left<=right){

            while(left<arr.length && arr[left].compareTo(pivot) <0) {
                left++;
            }
            while(right>0 && arr[right].compareTo(pivot) >0) {
                right--;
            }

            Comparable temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;

        }

        return left;

    }


}

