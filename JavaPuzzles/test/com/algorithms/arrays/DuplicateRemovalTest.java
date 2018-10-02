package com.algorithms.arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class DuplicateRemovalTest {

    @Test
    public void removeDuplicates() {
        int[] nums =  {0,0,1,1,1,2,2,3,3,4};
        int len = new DuplicateRemoval().removeDuplicates(nums);

        for(int i=0;i<len;i++) {
            System.out.print(nums[i]+" ");
        }

    }
}