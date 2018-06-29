package com.puzzles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Hackerrank problem on knight placement
 */
public class MultiKnightPlacement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int boardSize = sc.nextInt();
        ArrayList<Point> list = new ArrayList<>();
        ArrayList<Integer> finalList = new ArrayList<>();

        for(int i=1;i<boardSize;i++) {
            for(int j=1;j<boardSize;j++) {
                findKnightMovement(boardSize, 0,0,i,j,list,finalList);
            }

            for(Integer p1: finalList) {
                System.out.printf("%s ", p1);
            }
            finalList.clear();
            list.clear();
            System.out.println();
        }


    }

    private static void findKnightMovement(int boardSize, int x, int y, int i, int j, List<Point> path, List<Integer> pathLength) {
        if(x<0 || y<0 || x>boardSize || y>boardSize) {
            //discard path
            return;
        }
        path.add(new Point(x,y));

        if(x == boardSize-1 && y == boardSize-1) {
            //found the small path
            int size = path.size();
            boolean isDiscarded = false;
            for(Integer p2:pathLength) {
                if(size > p2 ){
                    //discard
                    isDiscarded = true;
                    break;
                }
            }

            if(!isDiscarded) pathLength.add(path.size());//found, make copy and store
            return;
        }

        findKnightMovement(boardSize, x+i, y+j, i, j, path, pathLength);
        findKnightMovement(boardSize, x-i, y+j, i, j, path, pathLength);
        findKnightMovement(boardSize, x-i, y-j, i, j, path, pathLength);
        findKnightMovement(boardSize, x+i, y-j, i, j, path, pathLength);

    }

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
