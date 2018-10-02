package com.algorithms.search;

public class Finder {

    /** find smallest element, greather than or equals to X in sorted array */
    private static int findSmallestElemGrtThanX(int[] arr, int x) {
        int low = 0;
        int high = arr.length-1;

        while(low<=high) {
            int mid = (low+high)/2;
            if(arr[mid]>=x && arr[mid-1] < x ) {
                return arr[mid];
            } else if(arr[mid]>x) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return 0;
    }

    /** find largest element, smaller than or equals to X in sorted array */
    private static int findLargestElemSmallThanX(int[] arr, int x) {
        int low = 0;
        int high = arr.length-1;

        while(low<=high) {
            int mid = (low+high)/2;
            if(arr[mid]<=x && arr[mid+1] > x ) {
                return arr[mid];
            } else if(arr[mid]>x) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        int[] arr = {1,2,5,6,8,9,11,15,18,20};
        int res = findSmallestElemGrtThanX(arr,7);
        assert(8 ==res):res;

        res = findLargestElemSmallThanX(arr,7);
        assert(6 == res):res;

    }
}

