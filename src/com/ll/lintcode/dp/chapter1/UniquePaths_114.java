package com.ll.lintcode.dp.chapter1;

/**
 * 有一个机器人的位于一个 m × n 个网格左上角。
 *
 * 机器人每一时刻只能向下或者向右移动一步。机器人试图达到网格的右下角。
 *
 * 问有多少条不同的路径？
 *
 * 样例
 * Example 1:
 *
 * Input: n = 1, m = 3
 * Output: 1
 * Explanation: Only one path to target position.
 * Example 2:
 *
 * Input:  n = 3, m = 3
 * Output: 6
 * Explanation:
 * 	D : Down
 * 	R : Right
 * 	1) DDRR
 * 	2) DRDR
 * 	3) DRRD
 * 	4) RRDD
 * 	5) RDRD
 * 	6) RDDR
 * 注意事项
 * n和m均不超过100
 * 且答案保证在32位整数可表示范围内。
 */
public class UniquePaths_114 {

    public int uniquePath(int m, int n){
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i ++){
            for (int j = 0; j < n; j++){
                if (i == 0 || j == 0){
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
             }
        }
        return dp[m - 1][n - 1];
    }


}
