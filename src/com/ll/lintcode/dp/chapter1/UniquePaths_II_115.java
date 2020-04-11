package com.ll.lintcode.dp.chapter1;

/**
 * "不同的路径" 的跟进问题：
 *
 * 现在考虑网格中有障碍物，那样将会有多少条不同的路径？
 *
 * 网格中的障碍和空位置分别用 1 和 0 来表示。
 *
 * 样例
 * Example 1:
 * 	Input: [[0]]
 * 	Output: 1
 *
 *
 * Example 2:
 * 	Input:  [[0,0,0],[0,1,0],[0,0,0]]
 * 	Output: 2
 *
 * 	Explanation:
 * 	Only 2 different path.
 *
 *
 * 注意事项
 * m 和 n 均不超过100
 */
public class UniquePaths_II_115 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        int rowNum = obstacleGrid.length;
        int colNum = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 0){
            return 0;
        }

        dp[0][0] = 1;

        for (int i = 1; i < rowNum; i++){
            dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i - 1][0];
        }
        for (int i = 1; i < colNum; i++){
            dp[0][i] = obstacleGrid[0][i] == 1 ? 0 : dp[0][i - 1];
        }

        for(int i = 1; i < rowNum; i ++){
            for (int j = 1; j < colNum; j ++){
                if (obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[rowNum - 1][colNum - 1];
    }
}
