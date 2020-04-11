package com.ll.lintcode.dp.chapter2;

import com.ll.muke.queue.Array;

import java.util.Arrays;

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

    public int minimumPathSum(int[][] grid){
        if (null == grid || grid.length < 1){
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        int i, j;
        for (i = 1; i < grid.length; i ++){
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }

        for (i = 1; i < grid[0].length; i ++){
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }

        for (i = 1; i < grid.length; i ++){
            for (j = 1; j < grid[i].length; j ++){
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[grid.length - 1][grid[0].length - 1];
    }

    public int minimumPathSum2(int[][] grid){
        if (null == grid || grid.length < 1){
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        int i, j;
        for(i = 0; i < grid.length; i ++){
            for (j = 0; j < grid[0].length; j ++){
                if (i == 0 && j == 0){
                    dp[i][j] = grid[i][j];
                    continue;
                }

                int tmp = Integer.MAX_VALUE;
                if (i > 0){
                    tmp = Math.min(tmp, dp[i - 1][j]);
                }

                if (j > 0){
                    tmp = Math.min(tmp, dp[i][j - 1]);
                }

                dp[i][j] = tmp + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    public int minimumPathSum3(int[][] grid){
        if (null == grid || grid.length < 1){
            return 0;
        }
        int[][] dp = new int[2][grid[0].length];
        int old, now = 1;
        for (int i = 0; i < grid.length; i ++){
            //swap old and now
            old = now;
            now = 1- now;
            for (int j = 0; j < grid[0].length; j ++){
                if (i  == 0 && j == 0){
                    dp[now][j] = grid[i][j];
                    continue;
                }
                int tmp = Integer.MAX_VALUE;
                if (i > 0){
                    tmp = Math.min(tmp,dp[old][j]);
                }

                if (j > 0){
                    tmp = Math.min(tmp, dp[now][j - 1]);
                }

                dp[now][j] = tmp + grid[i][j];
            }
        }

        return dp[now][grid[0].length - 1];
    }

    public int minimumPathSum4(int[][] grid){
        if (null == grid || grid.length < 1){
            return 0;
        }
        int[][] dp = new int[2][grid[0].length];
        for (int i = 0; i < grid.length; i ++){
            for (int j = 0; j < grid[0].length; j ++){
                if (i  == 0 && j == 0){
                    dp[i % 2][j] = grid[i][j];
                    continue;
                }
                int tmp = Integer.MAX_VALUE;
                if (i > 0){
                    tmp = Math.min(tmp,dp[1 - i % 2][j]);
                }

                if (j > 0){
                    tmp = Math.min(tmp, dp[i % 2][j - 1]);
                }

                dp[i % 2][j] = tmp + grid[i][j];
            }
        }

        return dp[(grid.length - 1) % 2][grid[0].length - 1];
    }

    //并且打印路径
    public int minimumPath(int[][] grid){
        if (null == grid || grid.length < 1){
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        //up : 0
        //left : 1
        int[][] pi = new int[grid.length][grid[0].length];
        int i, j;
        for(i = 0; i < grid.length; i ++){
            for (j = 0; j < grid[0].length; j ++){
                if (i == 0 && j == 0){
                    dp[i][j] = grid[i][j];
                    continue;
                }

                int tmp = Integer.MAX_VALUE;
                if (i > 0){
                    tmp = Math.min(tmp, dp[i - 1][j]);
                    if (tmp == dp[i - 1][j]){
                        pi[i][j] = 0;
                    }
                }

                if (j > 0){
                    tmp = Math.min(tmp, dp[i][j - 1]);
                    if (tmp == dp[i][j - 1]){
                        pi[i][j] = 1;
                    }
                }

                dp[i][j] = tmp + grid[i][j];
            }
        }

        //path: reverse order
        // 7, 3, 2, 3, 5, 1
        // 1, 5, 3, 2, 3, 7
        int[] path = new int[grid.length + grid[0].length - 1];
        int x = grid.length - 1;
        int y = grid[0].length - 1;
        for (int p = 0; p < grid.length + grid[0].length - 1; ++ p){
            path[p] = grid[x][y];
            if (pi[x][y] == 0){
                -- x;
            }else{
                -- y;
            }
        }

        for (int p = grid.length + grid[0].length - 2; p >= 0; --p){
            System.out.print(path[p] + " ");
        }

        return dp[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] data = new int[][]{ {1,5,7,6,8},
                                    {4,7,4,4,9},
                                    {10,3,2,3,2}};
        MinimumPathSum_110 dto = new MinimumPathSum_110();
        for (int i = 0; i < data.length; i ++){
            System.out.println(Arrays.toString(data[i]));
        }
        dto.minimumPath(data);
        System.out.println();
        System.out.println(dto.minimumPathSum2(data));
    }
}
