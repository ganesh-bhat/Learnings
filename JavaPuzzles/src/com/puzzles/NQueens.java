package com.puzzles;

import java.util.Arrays;
import java.util.Scanner;

public class NQueens {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int boardSize = sc.nextInt();
        System.out.println(boardSize);

        int[] board = new int[boardSize];
        Arrays.fill(board,-1);
        placeQueens(board, 0);
    }

    private static int num = 1;

    private static void placeQueens(int[] board, int row) {
        if(row == board.length) {
            //print answer
            System.out.println("Solution Number: "+(num++));
            System.out.print("--");
            for(int i=0;i<board.length;i++) {
                System.out.print(i);
            }
            System.out.println("");

            for(int i=0;i<board.length;i++) {
                char c = (char)('A'+i);
                System.out.print(c+" ");
                for(int col=0;col<board.length;col++) {
                    if(board[i] == col) {
                        System.out.print('X');
                    } else {
                        System.out.print('-');
                    }
                }
                System.out.println("");
            }
            return;
        }

        for(int i=0;i<board.length;i++) {
            if(canPlace(board,i,row)) {
                board[row] = i;
                placeQueens(board,row+1);
                board[row] = -1;//backtrack
            }
        }
    }

    private static boolean canPlace(int[] board, int col, int row) {
        if(col>=board.length || row>=board.length) {
            return false;
        }

        for(int i=0;i<=row;i++) {
            if(board[i]==col){
                return false;
            }
        }

        for(int i=0;i<row;i++) {
            int diffRow = row-i;
            int check1 = col+diffRow;
            int check2 = col-diffRow;
            if((check1>=0 && board[i] == check1) || check2>=0 && (board[i] == check2)) {
                return false;
            }
        }

        if(board[row] == -1) {// no queens placed
            return true;
        }
        return false;
    }
}
