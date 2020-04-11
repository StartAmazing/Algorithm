package com.ll.lintcode.basic.bfs;

import com.ll.lintcode.basic.utils.Coordinate;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland_433 {

    public int getNumberOfIsland(int[][] grid){

        if(grid == null || grid.length == 0){
            return 0;
        }

        int count = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j ++){
                if(grid[i][j] == 1) {
                    bfs(grid, i, j);
                    count ++;
                }
            }
        }

        return count;
    }

    private void dfs(int[][] grid, int row, int col){
        if(row < 0 || col < 0 || row > grid.length - 1 || col > grid[0].length -1 || grid[row][col] == 0 ){
            return;
        }

        grid[row][col] = 0;
        dfs(grid,row - 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row + 1, col);
        dfs(grid, row, col + 1);

    }

    private void bfs(int[][] grid, int row, int col){
        //magic number !
        //translate array
        int[] directionX = {0, 1, -1, 0};
        int[] directionY = {1, 0, 0, -1};

        Queue<Coordinate> queue = new LinkedList<>();

        queue.offer(new Coordinate(row,col));
        grid[row][col] = 2;
        while (!queue.isEmpty()){
            Coordinate curCoor = queue.poll();
            for(int i = 0; i < 4; i ++){
                Coordinate adj = new Coordinate(curCoor.x + directionX[i],
                        curCoor.y + directionY[i]);
                if(!inBound(adj, grid)){
                    continue;
                }

                if(grid[adj.x][adj.y] == 1){
                    grid[adj.x][adj.y] = 2;
                    queue.offer(adj);
                }
            }
        }
    }

    private boolean inBound(Coordinate coor, int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        return coor.x >= 0 && coor.y >= 0 && coor.x < grid.length && coor.y < grid[0].length;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,1,0,0,0},
                {0,1,0,0,1},
                {0,0,0,1,1},
                {0,0,0,0,0},
                {0,0,0,0,1}
        };
        NumberOfIsland_433 dto = new NumberOfIsland_433();
        int numberOfIsland = dto.getNumberOfIsland(grid);
        System.out.println(numberOfIsland);
    }
}
