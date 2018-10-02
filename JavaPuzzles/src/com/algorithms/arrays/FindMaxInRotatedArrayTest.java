package com.algorithms.arrays;

import com.algorithms.search.RotatedArrayQuestions;
import org.junit.Test;

public class FindMaxInRotatedArrayTest {

    @Test
    public void test() {
        System.out.println(RotatedArrayQuestions.findMaxElem(new int[]{4,5,6,7,1,2,3}));
        System.out.println(RotatedArrayQuestions.findMaxElem(new int[]{6,7,11,18,23,1,2,4}));

        System.out.println(RotatedArrayQuestions.find(new int[]{6,7,11,18,23,1,2,4}, 4));

    }

}