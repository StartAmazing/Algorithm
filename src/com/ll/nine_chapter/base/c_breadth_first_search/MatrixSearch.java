package com.ll.nine_chapter.base.c_breadth_first_search;

import sun.java2d.opengl.OGLRenderQueue;

import java.security.cert.PolicyNode;
import java.util.LinkedList;
import java.util.Queue;

public class MatrixSearch {

    /**
     * @link https://www.lintcode.com/problem/433/
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public static int numIslands(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null ||grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        int col = grid[0].length;
        int row = grid.length;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] && !visited[i][j]) {
                    count++;
                    bfsIsland(grid, i, j, visited);
                }
            }
        }

        return count;
    }

    private static void bfsIsland(boolean[][] grid, int x, int y, boolean[][] visited) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));
        visited[x][y] = true;
        int[] xMov = new int[]{0, 1, 0, -1};
        int[] yMov = new int[]{1, 0, -1, 0};
        while (!queue.isEmpty()) {
            Pair curPos = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextXPos = curPos.x + xMov[i];
                int nextYPos = curPos.y + yMov[i];
                if (nextXPos < grid.length && nextXPos >= 0 &&
                    nextYPos < grid[nextXPos].length && nextYPos >= 0
                        && grid[nextXPos][nextYPos] && !visited[nextXPos][nextYPos]) {
                    queue.add(new Pair(nextXPos, nextYPos));
                    visited[nextXPos][nextYPos] = true;
                }
            }
        }
    }

    private static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    /**
     * @link https://www.lintcode.com/problem/598/
     * @param grid: a 2D integer grid
     * @return: an integer
     */
    private static final Integer PEOPLE = 0;
    private static final Integer ZOMBIE = 1;
    private static final Integer WALL = 2;

    public static int zombie(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        Queue<ZombiePosition> queue = new LinkedList<>();
        //1. find all zombie pos before bfs
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == ZOMBIE) {
                    queue.add(new ZombiePosition(i, j));
                }
            }
        }

        if (queue.isEmpty()) {
            return -1;
        }

        int day = 0;
        int[] rowMov = new int[]{0, 0, 1, -1};
        int[] colMov = new int[]{1, -1, 0, 0};

        // bfs
        while (!queue.isEmpty()) {
            boolean infect = false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                ZombiePosition curPos = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nextRow = curPos.row + rowMov[j];
                    int nextCol = curPos.col + colMov[j];
                    if (validPos(grid, nextRow, nextCol)) {
                        infect = true;
                        queue.add(new ZombiePosition(nextRow, nextCol));
                        grid[nextRow][nextCol] = ZOMBIE;
                    }
                }
            }
            if (infect) {
                day++;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == PEOPLE) {
                    return -1;
                }
            }
        }

        return day;
    }

    private static boolean validPos(int[][] grid, int row, int col) {
        return row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] == PEOPLE;
    }

    private static class ZombiePosition {
        public int row;
        public int col;

        public ZombiePosition(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    /**
     * @Link https://www.lintcode.com/problem/611/
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if (grid == null || grid.length == 0) {
            return -1;
        }

        if (source.x == destination.x && source.y == destination.y) {
            return 0;
        }

        grid[source.x][source.y] = true;

        int[] movX = new int[]{1, 1, -1, -1, 2, 2, -2, -2};
        int[] movY = new int[]{2, -2, 2, -2, 1, -1, 1, -1};


        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point curPos = queue.poll();
                for (int j = 0; j < 8; j++) {
                    int nextX = curPos.x + movX[j];
                    int nextY = curPos.y + movY[j];
                    if (validPoint(grid, nextX, nextY)) {
                        if(nextX == destination.x && nextY == destination.y) {
                            return level;
                        }
                        queue.offer(new Point(nextX, nextY));
                        grid[nextX][nextY] = true;
                    }
                }
            }
        }

        return -1;
    }

    private boolean validPoint(boolean[][] grid, int nextX, int nextY) {
        return nextX >= 0 && nextY >= 0 && nextX < grid.length && nextY < grid[0].length && !grid[nextX][nextY];
    }

    class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
     }

    public static void main(String[] args) {
        boolean[][] island = new boolean[][]{
                {true, true, false, false},
                {false, false, true, false},
                {true, false, false, true},
                {false, false, true, true}};

        System.out.println(numIslands(island));

        int[][] zombieData = new int[][]{{0, 2, 0},
                                         {2, 2, 0},
                                         {2, 0, 1}};
        int days = zombie(zombieData);
        System.out.println(days);
    }
}
