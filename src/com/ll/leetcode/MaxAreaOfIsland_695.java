package com.ll.leetcode;

import java.time.temporal.ChronoField;

/**
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。
 * 你可以假设二维矩阵的四个边缘都被水包围着。
 *
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 *
 * 示例 1:
 *
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。
 *
 * 示例 2:
 *
 * [[0,0,0,0,0,0,0,0]]
 * 对于上面这个给定的矩阵, 返回 0。
 *
 * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-area-of-island
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxAreaOfIsland_695 {

    private int maxArea = 0;
    private int tmpArea = 0;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j ++){
                tmpArea = 0;
                getMaxArea(grid, i, j);
            }
        }

        return maxArea;
    }

    private void getMaxArea(int[][] grid, int row, int col){
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != 1){
            return;
        }
        grid[row][col] = 2;
        tmpArea += 1;
        getMaxArea(grid, row - 1, col);
        getMaxArea(grid, row, col + 1);
        getMaxArea(grid, row, col - 1);
        getMaxArea(grid, row + 1, col);

        maxArea = Math.max(tmpArea, maxArea);
    }

    public static void main(String[] args) {
        MaxAreaOfIsland_695 dto = new MaxAreaOfIsland_695();
        int[][] data = new int[][]{{1,1},{1,0}};
        dto.maxAreaOfIsland(data);
    }

}
