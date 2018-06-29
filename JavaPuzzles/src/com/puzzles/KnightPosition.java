package com.puzzles;

import java.util.*;

public class KnightPosition {

    static int size = 0;
    private static Cell terminalCell;

    public static int findMinSteps(int boardSize, int startX, int startY, int endX, int endY) {
        size = boardSize;
        terminalCell = new Cell(3,3);
        findMinSteps2(boardSize,0,0,3,3);
        return 0;
    }

    private static int findMinSteps2(int boardSize, int startX, int startY, int endX, int endY) {

        Set<Cell> visited = new HashSet<>();
        Queue<Cell> queue = (Queue<Cell>) new LinkedList<Cell>();
        queue.add(new Cell(0,0));

        List<Cell> path = new ArrayList<>();

        while(!queue.isEmpty()) {
            Cell cell = queue.poll();
            path.add(cell);

            if(isTerminal(cell)) {

                System.out.println(cell.dis);

                break;
            }

            visited.add(cell);
            List<Cell> neighbours = getNeighbours(cell);

            for(Cell neighbour:neighbours) {
                if(!visited.contains(neighbour)) {
                    queue.add(new Cell(neighbour, neighbour.dis+1));
                }
            }

        }

        System.out.println(path);


        return 0;
    }

    private static boolean isTerminal(Cell cell) {
        return cell.equals(terminalCell);
    }

    static List<Cell> getNeighbours(Cell cell) {
        int dx[] = {-2, -1, 1, 2, -2, -1, 1, 2};
        int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1};

        List<Cell> neighbours = new ArrayList<>();
        for(int i=0;i<dx.length;i++) {
            Cell neighbour = new Cell(cell.x+dx[i], cell.y+dy[i]);
            if(neighbour.isWithinBounds()) neighbours.add(neighbour);
        }
        return neighbours;
    }



    static class Cell {
        int x;
        int y;
        int dis  =1;

        public Cell(int i, int j) {
            this.x = i;
            this.y = j;
        }

        public Cell(Cell neighbour, int dis) {
            this.x = neighbour.x;
            this.y = neighbour.y;
            this.dis =dis;
        }

        public boolean isWithinBounds() {
            return (x>=0 && y>=0 && x<size && y<size);
        }

        @Override
        public int hashCode() {
           return 37+x+y;
        }

        public boolean equals(Object obj) {
            if(obj == null) return false;

            if(!(obj instanceof Cell) ) return false;

            Cell e = (Cell) obj;

            return this.x == e.x && this.y == e.y;
        }

        @Override
        public String toString() {
            return String.format("{x=%d,y=%d}",x,y);
        }
    }


    public static void main(String[] args) {
        findMinSteps(4,0,0,3,3);
    }


}
