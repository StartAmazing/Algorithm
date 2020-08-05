package com.ll.lintcode.advance.chapter5.dp;

/**
 * 在一个二维01矩阵中找到全为1的最大正方形, 返回它的面积.
 * <p>
 * 样例
 * 样例 1:
 * <p>
 * 输入:
 * [
 * [1, 0, 1, 0, 0],
 * [1, 0, 1, 1, 1],
 * [1, 1, 1, 1, 1],
 * [1, 0, 0, 1, 0]
 * ]
 * 输出: 4
 * 样例 2:
 * <p>
 * 输入:
 * [
 * [0, 0, 0],
 * [1, 1, 1]
 * ]
 * 输出: 1
 */
public class MaximalSquare_436 {

    public int maxSquare1(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return 0;
        }

        int ans = 0;

        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = matrix[i][0];
            ans = Math.max(dp[i][0], ans);
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = matrix[0][i];
            ans = Math.max(dp[0][i], ans);
        }

        int[] left;
        int[][] up = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < up.length; i++) {
            for (int j = 0; j < up[i].length; j++) {
                if (i == 0) {
                    up[i][j] = 0;
                } else {
                    if (matrix[i][j] == 0) {
                        up[i][j] = 0;
                    } else {
                        up[i][j] = (matrix[i - 1][j] == 0 ? 0 : up[i - 1][j] + 1);
                    }
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            left = new int[matrix[i].length];
            left[0] = matrix[i][0];
            for (int j = 1; j < matrix[0].length; j++) {
                dp[i][j] = matrix[i][j];
                if (dp[i][j] != 0 && dp[i - 1][j - 1] != 0) {
                    if (matrix[i][j - 1] == 0) {
                        left[j] = 0;
                    } else {
                        left[j] = left[j - 1] + 1;
                    }
                    dp[i][j] = Math.min(left[j], Math.min(dp[i - 1][j - 1], up[i][j])) + 1;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans * ans;
    }


    public int maxSquare2(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return 0;
        }

        int ans = 0;

        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = matrix[i][0];
            ans = Math.max(dp[i][0], ans);
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = matrix[0][i];
            ans = Math.max(dp[0][i], ans);
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                dp[i][j] = matrix[i][j];
                if (dp[i][j] != 0 && dp[i - 1][j - 1] != 0) {

                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans * ans;
    }

    public int maxSquare3(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return 0;
        }

        int ans = 0;

        int[][] dp = new int[2][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i % 2][j] = matrix[i][j];
                } else {
                    dp[i % 2][j] = matrix[i][j];
                    if (dp[i % 2][j] != 0 && dp[(i - 1) % 2][j - 1] != 0) {
                        dp[i % 2][j] = Math.min(dp[(i - 1) % 2][j], Math.min(dp[(i - 1) % 2][j - 1], dp[i % 2][j - 1])) + 1;
                    }
                }
                ans = Math.max(ans, dp[i % 2][j]);
            }
        }

        return ans * ans;
    }

    public static void main(String[] args) {
        MaximalSquare_436 dto = new MaximalSquare_436();
        int[][] data = new int[][]{{1, 0, 1, 0, 0}, {1, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 0, 0, 1, 0}};
        System.out.println(dto.maxSquare3(data));
    }
}
