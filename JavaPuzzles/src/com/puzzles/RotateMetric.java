package com.puzzles;

import java.util.Arrays;

public class RotateMetric {

    enum RotationDegree{
        ROTATE_90, ROTATE_180, ROTATE_270
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4,5,6},
                {7,8,9,10,11,12},
                {13,14,15,16,17,18},
                {19,20,21,22,23,24},
                {25,26,27,28,29,30},
                {31,32,33,34,35,36}
        };
        rotate(RotationDegree.ROTATE_90, matrix);

        for(int i=0;i<matrix.length;i++) {
             System.out.println(Arrays.toString(matrix[i]));
        }


    }

    private static void rotate(RotationDegree rotate90, int[][] matrix) {

        switch (rotate90) {
            case ROTATE_270: rotate90(matrix);
            case ROTATE_180: rotate90(matrix);
            case ROTATE_90: rotate90(matrix);
            break;
            default:
                rotate90(matrix);
        }
    }


    //default 90%
    private static void rotate90(int[][] matrix) {
        boolean isEven = (matrix.length % 2 == 0);
        int minLayerSize = isEven? 0 : 1;
        int len = matrix.length-1;
        for(int layerSize=len;layerSize>minLayerSize;layerSize--) {
            if(len-layerSize>=layerSize) {
                break;
            }
            int[] left = topToLeft(matrix, len-layerSize ,layerSize);
            int[] right = bottomToRight(matrix, len-layerSize ,layerSize);
            updateTop(matrix, right, len-layerSize ,layerSize);
            updateBottom(matrix, left,len-layerSize ,layerSize);
        }
    }

    private static int[] topToLeft(int[][] matrix, int start, int end) {
        System.out.println("end:"+end+",start:"+start);
        int[] tempLeft = new int[end-start];
        for(int i=start;i<end;i++) {
            tempLeft[i-start] = matrix[i][start];
            matrix[i][start] = matrix[start][end-1-i];
        }
        return tempLeft;
    }

    private static void updateTop(int[][] matrix, int[] top, int start, int end) {
        for(int i=start;i<end;i++) {
            matrix[start][i] = top[i-start];
        }
    }


    private static int[] bottomToRight(int[][] matrix, int start, int end) {
        int[] tempRight = new int[end-start];
        for(int i=start;i<end;i++) {
            tempRight[i-start] = matrix[i][end];
            matrix[i][end] = matrix[end][end-i];
        }
        return tempRight;
    }

    private static void updateBottom(int[][] matrix,int[] bottom, int start, int end) {
        for(int i=start;i<end;i++) {
            matrix[end][i+1] = bottom[i-start];
        }
    }

}
