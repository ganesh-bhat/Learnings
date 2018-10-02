package com.common.java;

public class CountDuplicatesInSorted {

    public static void main(String[] args) {
        //test cases
        //int[] arr = {1,2,3,5,5,5,5,6,8};
        //int[] arr = {1,2,3,5,5,5,5};
        //int[] arr = {5,5,5,5,6,8};
        //int[] arr = {5};
        //int[] arr = {};
        //int[] arr = {2};
        //int[] arr = {5,6,8,1,2,3};
        int[] arr = {5,6,8,1,2,3,3,3,4};
        int x = 3;
        int total = countOccurance(arr, x);
        System.out.println(total);





    }

    private static int countOccurance(int[] arr, int x) {
        int first = firstOccurance(arr,x);

        if(first>=0) {
            int count = 0;
            for(int i=first; i<arr.length && (arr[i] == x) ;i++,count++);
            return count;
        }
        return 0;

    }

    private static int firstOccurance(int[] arr, int x) {
        int low = 0;
        int high = arr.length-1;

        while (low<=high) {
            int mid = (low+high)/2;

            if((mid == 0||arr[mid-1]<x) && arr[mid] == x) {
                return mid;
            } else if(x > arr[mid]) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -(low+1);
    }
}
