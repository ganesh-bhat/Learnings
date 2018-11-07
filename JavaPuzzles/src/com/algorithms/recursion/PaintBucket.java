package com.algorithms.recursion;

import java.util.Arrays;

public class PaintBucket {

    public static void paint(int[][] canvas, int x, int y,
                             int orgColor, int newColor){
        if(canvas == null || canvas.length == 0) return;
        if(x>=canvas.length || y >= canvas[0].length
                || x<0 || y<0) return;

        if(canvas[x][y] == orgColor) canvas[x][y] = newColor;

        int[] dxs = {-1,1,0};
        int[] dys = {-1,1,0};

        for(int dx:dxs) {
            for(int dy:dys) {
                if(x+dx>=canvas.length || y+dy >= canvas[0].length
                        || x+dx<0 || y+dy<0 || canvas[x+dx][y+dy] != orgColor) continue;

                paint(canvas, x+dx,y+dy,orgColor,newColor);
            }
        }

    }

    public static void main(String[] args) {
        int[][] canvas = {
                {1,1,0,1},
                {1,0,0,1},
                {1,0,0,1},
                {0,1,1,1},
        };

        System.out.println(Arrays.deepToString(canvas).replaceAll("],","]\n"));
        paint(canvas,1,2,canvas[1][2],2);

        System.out.println("-------After paint-----");
        System.out.println(Arrays.deepToString(canvas).replaceAll("],","]\n"));

    }

}

