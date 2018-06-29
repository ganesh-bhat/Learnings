package com.algorithms.arrays;

/**
 * Kadane algorithm to find largest subarray sum
 */
public class LargestArraySum_Kadane {


    public static Result largestSubArraySum(int[] array) {

        int sumSoFar = 0;
        int sumAtCurrentIdx = 0;
        int startIndex = 0;
        int endIndex = 0;
        for(int i=0;i<array.length;i++) {
            sumAtCurrentIdx+=array[i];

            if(sumAtCurrentIdx<0) {
                sumAtCurrentIdx = 0;
                startIndex = i+1;//restart index to next position than current
            }
            if(sumSoFar < sumAtCurrentIdx) {
                sumSoFar = sumAtCurrentIdx;
                endIndex = i;
            }
        }

        return new Result(startIndex,endIndex,sumSoFar);

    }


    static class Result {
        int start;
        int end;
        int sum;

        public Result(int startIndex, int endIndex, int sumSoFar) {
            start = startIndex;
            end = endIndex;
            sum = sumSoFar;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "start=" + start +
                    ", end=" + end +
                    ", sum=" + sum +
                    '}';
        }
    }

}
