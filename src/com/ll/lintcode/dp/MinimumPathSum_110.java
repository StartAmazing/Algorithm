package com.ll.lintcode.dp;

/**
 * 给定一个只含非负整数的m*n网格，找到一条从左上角到右下角的可以使数字和最小的路径。
 *
 *
 *
 * 样例
 * 样例 1:
 * 	输入:  [[1,3,1],[1,5,1],[4,2,1]]
 * 	输出: 7
 *
 * 	样例解释：
 * 	路线为： 1 -> 3 -> 1 -> 1 -> 1。
 *
 *
 * 样例 2:
 * 	输入:  [[1,3,2]]
 * 	输出:  6
 *
 * 	解释:
 * 	路线是： 1 -> 3 -> 2
 *
 * 注意事项
 * 你在同一时间只能向下或者向右移动一步
 */
public class MinimumPathSum_110 {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length < 1){
            return -1;
        }

        int[][] f = new int[grid.length][grid[0].length];
        f[0][0] = grid[0][0];

        for (int i = 1; i < grid.length; i++){
            f[i][0] = grid[i][0] + f[i - 1][0];
        }
        for (int i = 1; i < grid[0].length; i++){
            f[0][i] = grid[0][i] + f[0][i - 1];
        }

        for (int i = 1; i < grid.length; i++){
            for (int j = 1; j < grid[0].length; j ++){
                f[i][j] = grid[i][j] + Math.min(f[i - 1][j], f[i][j - 1]);
            }
        }

        return f[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        MinimumPathSum_110 dto = new MinimumPathSum_110();
        int[][] data = new int[][]{{1,3,1},{1,5,1},{4,2,1}};

        dto.minPathSum(data);
    }
}
