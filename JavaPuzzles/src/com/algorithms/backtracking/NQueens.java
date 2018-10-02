package com.algorithms.backtracking;

import com.Utils;

import java.util.Arrays;

public class NQueens {


    private static boolean placeNQueens(int boardSize, int row, boolean[][] placement) {

        if(row == boardSize) {
            //print solution
            Utils.prettyPrintBooleanMatrix(placement,"X"," ");

        }

        for(int column=0;column<boardSize;column++) {
            if(isSafe(row, column,placement)) {
                placement[row][column] = true;
                placeNQueens(boardSize,row+1,placement);
                placement[row][column] = false;//backtrack
            }
        }

        return false;

    }

    private static boolean isSafe(int row, int column, boolean[][] placement) {
        for(int i=0;i<row;i++) {
            if(placement[i][column]) {
                //same column shared
                return false;
            }
        }

        //diagonal shared
        for(int i=row, j =column;i>=0 && j>=0;i--,j--) {
            if(placement[i][j]) {
                //same column shared
                return false;
            }
        }

        //diagonal shared
        for(int i=row, j =column ;i>=0 && j<placement.length;i--,j++) {
            if(placement[i][j]) {
                //same column shared
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        boolean[][] placement = new boolean[4][4];
        placeNQueens(4,0,placement);
    }

}
