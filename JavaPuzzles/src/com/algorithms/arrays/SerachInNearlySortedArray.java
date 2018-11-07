package com.algorithms.arrays;

public class SerachInNearlySortedArray {

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 5, 4, 7, 6, 8, 9};

        int index = modifiedBinarySearch(arr, 11);
        if(index!=-1) {
            System.out.println("found at index:"+index);
        } else {
            System.out.println("Not found");
        }


    }

    private static int modifiedBinarySearch(int[] arr, int key) {

        int start = 0;
        int end = arr.length-1;

        while(start <= end) {
            int mid = (start+end)/2;
            if(arr[mid] == key) {
                return mid;
            } else if(mid+1< arr.length && arr[mid+1] == key) {
                return mid+1;
            } else if(mid-1>= 0 && arr[mid-1] == key) {
                return mid-1;
            } else if(mid+1< arr.length && mid-1>= 0  && arr[mid+1] > key && arr[mid] > key && arr[mid-1]> key) {
                end = mid-2;
            } else if(mid+1>= arr.length && mid-1>= 0  && arr[mid] > key && arr[mid-1]> key){
                end = mid-2;
            } else if(mid+1< arr.length && mid-1< 0  && arr[mid] > key && arr[mid+1] > key){
                end = mid-2;
            } else {
                start = mid+2;
            }
        }
        return -1;

    }
}
