package com.ll.lintcode.dp.chapter4;

/**
 * 给一个正整数 n, 请问最少多少个完全平方数(比如1, 4, 9...)的和等于n。
 *
 * 样例
 * 样例 1:
 *
 * 输入: 12
 * 输出: 3
 * 解释: 4 + 4 + 4
 * 样例 2:
 *
 * 输入: 13
 * 输出: 2
 */
public class PerfectSquares_513 {

    public int numSquares(int num) {
        if (num < 1){
            return 0;
        }
        int[] dp = new int[num + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i ++){
            dp[i] = Integer.MIN_VALUE;
            for (int j = 1; j * j <= i; j ++){
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[num];
    }

}
