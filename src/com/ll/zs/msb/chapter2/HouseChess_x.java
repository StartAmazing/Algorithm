package com.ll.zs.msb.chapter2;

/**
 * 给定一个中国象棋棋盘(11 * 9), 一只马从右下角，记为(0, 0)处开始行走(马走日), 求到达棋盘(x, y) 处需要恰好走K步的方法个数
 */
public class HouseChess_x {

    // with recursion
    public int houseJumpWays(int x, int y, int k) {
        if (k == 0 ){
            return x == 0 && y == 0 ? 1 : 0;
        }
        if (x < 0 || y < 0 || x >= 9 || y >= 11) {
            return 0;
        }
        int a = houseJumpWays(x - 1, y + 2, k - 1);
        int b = houseJumpWays(x + 1, y + 2, k - 1);
        int c = houseJumpWays(x + 2, y + 1, k - 1);
        int d = houseJumpWays(x + 2, y - 1, k - 1);
        int e = houseJumpWays(x + 1, y - 2, k - 1);
        int f = houseJumpWays(x - 1, y - 2, k - 1);
        int g = houseJumpWays(x - 2, y - 1, k - 1);
        int h = houseJumpWays(x - 2, y + 1, k - 1);

        return a + b + c + d + e + f + g + h;
    }

    // with dp
    public int houseJumpWays_2(int x, int y, int k) {
        int[][][] dp = new int[9][11][k + 1];
        dp[0][0][0] = 1; // 剩下的dp[0][0][n] == 0
        for(int i = 1; i <= k; i++) {  // k
            for (int j = 0; j < 9; j++) { // x
                for (int n = 0; n < 11; n++) {  // y
                    dp[j][n][i] = 0;
                    if (j - 1 >= 0 && n - 2 >= 0) {
                        dp[j][n][i] += dp[j - 1][n - 2][i - 1];
                    }
                    if (j - 1 >= 0 && n + 2 < 11) {
                        dp[j][n][i] += dp[j - 1][n + 2][i - 1];
                    }
                    if (j + 1 < 9 && n - 2 >= 0) {
                        dp[j][n][i] += dp[j + 1][n - 2][i - 1];
                    }
                    if (j + 1 < 9 && n + 2 < 11) {
                        dp[j][n][i] += dp[j + 1][n + 2][i - 1];
                    }
                    if (j - 2 >= 0 && n + 1 < 11) {
                        dp[j][n][i] += dp[j - 2][n + 1][i - 1];
                    }
                    if (j - 2 >= 0 && n - 1 >= 0) {
                        dp[j][n][i] += dp[j - 2][n - 1][i - 1];
                    }
                    if (j + 2 < 9 && n + 1 < 11) {
                        dp[j][n][i] += dp[j + 2][n + 1][i - 1];
                    }
                    if (j + 2 < 9 && n - 1 >= 0) {
                        dp[j][n][i] += dp[j + 2][n - 1][i - 1];
                    }
                }
            }
        }
        return dp[x][y][k];
    }

    public static void main(String[] args) {
        HouseChess_x dto = new HouseChess_x();
        int x = 3, y = 2;
        long startTime = System.currentTimeMillis();
        int count = dto.houseJumpWays(x, y, 11);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        System.out.println(count);
        startTime = System.currentTimeMillis();
        int count2 = dto.houseJumpWays_2(x, y, 11);
        endTime = System.currentTimeMillis();
        System.out.println(count2);
        System.out.println(endTime - startTime);
    }

}
