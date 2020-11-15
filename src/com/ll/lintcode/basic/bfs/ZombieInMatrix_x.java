package com.ll.lintcode.basic.bfs;

import com.ll.utils.Coordinate;

import java.util.LinkedList;
import java.util.Queue;

public class ZombieInMatrix_x {
    public final int PEOPLE = 0;
    public final int ZOMBIE = 1;
    public final int WALL = 2;

    public int[] directX = {0, 0, 1, -1};
    public int[] directY = {1, -1, 0, 0};

    /**
     * @param grid is a 2D integer matrix
     * @return an integer
     */
    public int zombie(int[][] grid){
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }

        //initialize the queue & count people
        int people = 0;
        Queue<Coordinate> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == PEOPLE){
                    people ++;
                }else if(grid[i][j] == ZOMBIE){
                    queue.offer(new Coordinate(i,j));
                }
            }
        }

        //corner case
        if(people == 0){
            return 0;
        }

        //bfs
        int days = 0;
        while (!queue.isEmpty()){
            days ++;
            int size = queue.size();
            for (int i = 0; i < size; i++){
                Coordinate zb = queue.poll();
                for(int direction = 0; direction < 4; direction ++){
                    Coordinate adj = new Coordinate(zb.x + directX[direction],
                                                    zb.y + directY[direction]);
                    if(!isPeople(adj, grid)){
                        continue;
                    }

                    grid[adj.x][adj.y] = ZOMBIE;
                    people --;

                    if(people == 0){
                        return days;
                    }

                    queue.offer(adj);
                }
            }
        }


        return days;

    }
    private boolean isPeople(Coordinate coordinate, int[][] grid){
        int x = grid.length;
        int y = grid[0].length;

        return  coordinate.x >= 0 &&
                coordinate.y >= 0 &&
                coordinate.x < x &&
                coordinate.y < y &&
                grid[coordinate.x][coordinate.y] == PEOPLE;
    }
}
