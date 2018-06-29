package com.algorithms.arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class LargestArraySum_KadaneTest {

    @Test
    public void largestSubArraySum() {

        LargestArraySum_Kadane.Result res = LargestArraySum_Kadane.largestSubArraySum(new int[]{-14, -1, -2, 5, -3, 4, 6, 8, -18});
        System.out.println(res);
        res = LargestArraySum_Kadane.largestSubArraySum(new int[]{-14, -1, -2, 5, -16, 4, 6, 8, -18});
        System.out.println(res);
    }
}