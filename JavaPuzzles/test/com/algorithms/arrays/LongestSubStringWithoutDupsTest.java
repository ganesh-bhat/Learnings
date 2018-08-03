package com.algorithms.arrays;

import org.junit.Assert;
import org.junit.Test;

public class LongestSubStringWithoutDupsTest {

    @Test
    public void testFind1() {
        int x = LongestSubStringWithoutDups.findOptimal("ancbda");
        Assert.assertEquals(5, x);

       x = LongestSubStringWithoutDups.findOptimal("baaancbda");
        Assert.assertEquals(5, x);

        x = LongestSubStringWithoutDups.find1("baaancbda");
        Assert.assertEquals(5, x);
    }


}