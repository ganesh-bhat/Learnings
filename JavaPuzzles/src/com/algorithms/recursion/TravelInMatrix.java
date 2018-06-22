package com.algorithms.recursion;

/**
 * Created by ganes on 20-05-2018.
 */
public class TravelInMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,0,1,0,0},
                {1,1,1,1,0},
                {0,0,0,1,0},
                {1,1,1,1,0},
                {0,1,0,1,1}
        };

        computePath(matrix,0,0,4,4);
    }

    static void computePath(int[][] matrix, int x1, int y1, int x2, int y2) {
        System.out.println("Visiting x:"+x1+", y:"+y1);
        if(x1>=x2 &&
                y1>=y2) {
            return;
        }

        if(x1+1<=x2 && matrix[x1+1][y1] == 1) {
            computePath(matrix,x1+1,y1,x2,y2);
        }
        if(y1+1<=y2 && matrix[x1][y1+1] == 1) {
            computePath(matrix,x1,y1+1,x2,y2);
        }
    }
}
