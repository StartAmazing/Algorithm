package com.ll.lintcode.advance.chapter5.dp.memorization;

/**
 * Give you an integer matrix(with row size m), find the longest increasing continuous
 * subsequence in this matrix. (The definition of the longest increasing continuous
 * subsequence here can start an any row or column and go up/down/right/left any direction)
 *
 *
 * memorization
 */
public class LongestIncreasingContinuousSubsequenceII_398 {

    private boolean[][] visited;
    private int[][] dp;
    private int[] dx = new int[]{1, -1, 0, 0};
    private int[] dy = new int[]{0, 0, 1, -1};

    public int longestIncreasingContinuousSubsequenceII(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return 0;
        }

        int ans = 0;
        dp = new int[matrix.length][matrix[0].length];
        visited = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                dp[i][j] = search(i, j, matrix);
                ans = Math.max(dp[i][j], ans);
            }
        }

        return ans;
    }


    private int search(int x, int y, int[][] matrix) {
        if (visited[x][y]) {
            return dp[x][y];
        }

        int ans = 1;
        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = x + dy[i];
            if (nx >= 0 && ny >= 0 && nx < matrix.length && ny < matrix[0].length) {
                if (matrix[nx][ny] < matrix[x][y]) {
                    ans = Math.max(search(nx, ny, matrix) + 1, ans);
                }
            }
        }
        visited[x][y] = true;
        dp[x][y] = ans;
        return ans;
    }

}
