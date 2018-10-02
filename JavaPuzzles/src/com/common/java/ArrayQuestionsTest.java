package com.common.java;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ArrayQuestionsTest {

    @Test
    public void findPeakLinear() {
        int res =  ArrayQuestions.findPeakLinear(new int[]{4,9,6,7,9});
        System.out.println(res);


    }

    @Test
    public void rotateArrayTest() {
        int[] array = {1,2,3,4,5,6,7,8};
        ArrayQuestions.rotateArray(array, 3);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void rotateTest() {
        Integer[] array = {1,2,3,4,5,6,7};
        ArrayQuestions.rotate(array);
        ArrayQuestions.rotate(array, 3);
        System.out.println(Arrays.toString(array));
    }


    @Test
    public void testExchangeDianonals() {
        Integer[][] array = {{0,1,2,3},
                        {4,5,6,7},
                        {8,9,10,11},
                        {12,13,14,15}
                            };

        ArrayQuestions.exchangeDiagonals(array);
        System.out.println(Arrays.deepToString(array).replace("], ", "]\n").replace("[[","[").replace("]]","]"));
    }

}