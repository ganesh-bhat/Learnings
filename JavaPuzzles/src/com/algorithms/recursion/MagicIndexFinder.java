package com.algorithms.recursion;

//magic index finder
public class MagicIndexFinder {

    /** arr - sorted array with possible magic index*/
    private static int magicIndexFinder(int[] arr) {
        if(arr.length <= 0 ) return -1;

        int low = 0;
        int high = arr.length-1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(mid == arr[mid]) {
                return mid;
            }else if(mid > arr[mid]){
                low = mid+1;
            } else if(mid < arr[mid]) {
                high = mid-1;
            }
        }
        return -(low+1);
    }

    public static void main(String[] args) {
        int[] arr = {-2,-1,2,4,8};
        int magicIdx = magicIndexFinder(arr);
        System.out.println("magic index is:"+magicIdx);

        int[] arr2 = {-8,-3,-1,2,3,5,6,8};
        magicIdx = magicIndexFinder(arr2);
        System.out.println("magic index is:"+magicIdx);
    }

}

