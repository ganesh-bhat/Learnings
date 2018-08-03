package com.puzzles;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AreaInHistogramTest {

    @Test
    public void findArea() {

        int[] histo = {2,4,1,3,5,3,4,3};
        Assert.assertEquals(AreaInHistogram.findArea(histo), AreaInHistogram.findArea2(histo));
        System.out.println(AreaInHistogram.findArea2(histo));
    }


}