package com.algorithms.arrays;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UniqueTripletsFormZeroTest {

    @Test
    public void uniqueTriplets() {

        List<List<Integer>> result = UniqueTripletsFormZero.uniqueTriplets(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(result);

    }


}