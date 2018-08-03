package com.puzzles;

import java.util.Stack;

public class AreaInHistogram {

    /*
        brute force gives n^2 complexity
     */
    public static int findArea(int[] histogram) {

        int maxArea = Integer.MIN_VALUE;

        for(int i=0;i<histogram.length;i++) {
            int minHeight = histogram[i];
            for(int j=i;j<histogram.length;j++) {
                minHeight = Math.min(minHeight, histogram[j]);
                maxArea = Math.max(maxArea, minHeight* (j-i+1));
            }
        }
        return maxArea;
    }

    /*
    stack based solution
     */
    public static int findArea2(int[] height) {
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        int cur = 0;
        int maxArea = Integer.MIN_VALUE;
        while(i<height.length) {
            if(stack.isEmpty() || height[i] > height[stack.peek()]) {
                stack.push(i);
            } else {
                cur = stack.pop();
                int width = Integer.MIN_VALUE;
                if(stack.isEmpty()) {
                    width = i;
                } else {
                    width = i-stack.peek()-1;
                }

                maxArea = Math.max(maxArea, width*height[cur]);
                i--;
            }
            i++;
        }

        while(!stack.isEmpty()) {
            cur = stack.pop();
            int width = Integer.MIN_VALUE;
            if(stack.isEmpty()) {
                width = i;
            } else {
                width = i-1 - stack.peek();
            }
            maxArea = Math.max(maxArea, width*height[cur]);
        }

        return maxArea;
    }
}
