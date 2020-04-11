package com.ll.lintcode.basic.dp;

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
public class UniquePathsII_115 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null){
            return -1;
        }
        int[][] f = new int[obstacleGrid.length][obstacleGrid[0].length];
        if (obstacleGrid[0][0] == 0){
            f[0][0] = 1;
        }else{
            return 0;
        }

        for (int i = 1; i < obstacleGrid.length; i ++){
            if (obstacleGrid[i][0] == 0){
                f[i][0] = 1;
            }else{
                for (int j = i; j < obstacleGrid.length; j ++){
                    f[j][0] = 0;
                }
                break;
            }
        }

        for (int i = 1; i < obstacleGrid[0].length; i ++){
            if (obstacleGrid[0][i] == 0){
                f[0][i] = 1;
            }else{
                for (int j = i; j < obstacleGrid[0].length; j ++){
                    f[0][j] = 0;
                }
                break;
            }
        }

        for (int i = 1; i < obstacleGrid.length; i ++){
            for (int j = 1; j < obstacleGrid[0].length; j ++){
                if (obstacleGrid[i][j] == 0){
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }else{
                    f[i][j] = 0;
                }
            }
        }
        return f[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
