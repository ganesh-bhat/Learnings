package com.algorithms.arrays;

/**
 * Find subsets of given array
 */
public class Subsets {

    static void findSubsets(int[] nums) {
        int count = 1 << nums.length; //2 power n subsets

        for(int i=0;i<count;i++) {
            for(int j=0;j<nums.length;j++) {
                if((i&(1<<j)) >0 ) {
                    System.out.print(nums[j]+" ");
                }
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        findSubsets(new int[]{1,2,3});
    }
}
