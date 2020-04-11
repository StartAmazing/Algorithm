package com.ll.lintcode.basic.dp;

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

    public int uniquePaths(int m, int n) {
        if (m < 1 || n < 1) {
            return -1;
        }

//        if (m == 1 || n == 1){
//            return 1;
//        }

        int[][] f = new int[m][n];
        for (int i = 0; i < m; i ++){
            f[i][0] = 1;
        }
        for (int i = 0; i < n; i ++){
            f[0][i] = 1;
        }

        for (int i = 1; i < m; i++ ){
            for (int j = 1; j < n; j ++){
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }

        return f[m - 1][n - 1];
    }

}
