package com.algorithms.arrays;

/*

Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

 */
public class DuplicateRemoval {

    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        if(nums.length == 1) {
            return 1;
        }

        int left = 0;
        int right = 0;

        while(right < nums.length) {
            while(right < nums.length-1 && nums[right] == nums[right+1]){
                right++;
            }
            nums[left++] = nums[right++];
        }

        return left;
    }


}
