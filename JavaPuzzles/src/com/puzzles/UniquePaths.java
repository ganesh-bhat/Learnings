package com.puzzles;

/**
 * https://leetcode.com/problems/unique-paths-ii/description/
 */
public class UniquePaths {

     public static void main(String[] args) {
         int[][] arr = {{0},{0}};
         new UniquePaths().uniquePathsWithObstacles(arr);
      }


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
         if(obstacleGrid.length == 0) {
             return 1;
         } else if(obstacleGrid.length == 1 && obstacleGrid[0].length == 1){
             return obstacleGrid[0][0] == 1?0:1;
         }
         return uniquePathsWithObstacles(obstacleGrid,0,0);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid, int x, int y) {
        if(x>= obstacleGrid.length || y>=obstacleGrid[x].length) {
            return 0;
        } else if(x == obstacleGrid.length-1 && y == obstacleGrid.length-1) {
            if(obstacleGrid[x][y] == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        int count = 0;
        if(x < obstacleGrid.length && y < obstacleGrid[x].length) {
            if(obstacleGrid[x][y] == 0) {
                count = uniquePathsWithObstacles(obstacleGrid,x+1,y) +
                        uniquePathsWithObstacles(obstacleGrid,x,y+1);
            }
        } else if(x < obstacleGrid.length) {
            if(obstacleGrid[x][y] == 0) {
                count = uniquePathsWithObstacles(obstacleGrid,x+1,y);
            }
        } else if(y < obstacleGrid[x].length) {
            if(obstacleGrid[x][y] == 0) {
                count = uniquePathsWithObstacles(obstacleGrid,x,y+1);
            }
        } else {
            return 0;
        }
        return count;
    }



}
