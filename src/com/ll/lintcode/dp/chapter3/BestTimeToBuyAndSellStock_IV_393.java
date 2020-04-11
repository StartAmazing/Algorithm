package com.ll.lintcode.dp.chapter3;

import com.sun.media.sound.SoftLowFrequencyOscillator;
import org.omg.CORBA.INTERNAL;

/**
 * 给定数组 prices, 其中第 i 个元素代表某只股票在第 i 天第价格.
 *
 * 你最多可以完成 k 笔交易. 问最大的利润是多少?
 *
 * 样例
 * 样例 1:
 *
 * 输入: k = 2, prices = [4, 4, 6, 1, 1, 4, 2 ,5]
 * 输出: 6
 * 解释: 以 4 买入, 以 6 卖出. 然后再以 1 买入, 以 5 卖出. 利润为 2 + 4 = 6.
 * 样例 2:
 *
 * 输入: k = 1, prices = [3, 2, 1]
 * 输出: 0
 * 解释: 不进行交易
 * 挑战
 * O(nk) 时间复杂度. n 是 prices 数组的大小.
 *
 * 注意事项
 * 你不可以同时参与多笔交易(你必须在再次购买前出售掉之前的股票)
 */
public class BestTimeToBuyAndSellStock_IV_393 {

    public int maxProfit(int k, int[] nums){
        if (k < 1 || null == nums || nums.length < 1){
            return 0;
        }
        if (k > nums.length / 2) {
            return buyAnyTimes(nums);
        }

        int[][] dp = new int[nums.length + 1][2 * (k + 1)];
        int i, j;
        dp[0][1] = 0;
        for (i = 2; i < 2 * (k + 1); i ++){
            dp[0][i] = Integer.MIN_VALUE;
        }

        for (i = 1; i < nums.length + 1; i ++){
            for (j = 1; j < 2 * (k + 1); j += 2){
                dp[i][j] = dp[i - 1][j];
                if (j > 1 && dp[i - 1][j - 1] != Integer.MIN_VALUE){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + nums[i - 1] - nums[i - 2]);
                }
            }

            for (j = 2; j < 2 * (k + 1); j += 2){
                dp[i][j] = dp[i - 1][j - 1];
                if (dp[i - 1][j] != Integer.MIN_VALUE){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + nums[i - 1] - nums[i - 2]);
                }
            }
        }
        int res = 0;
        for(i = 1; i < (k + 1) * 2; i ++){
            res = (Math.max(res, dp[nums.length][i]));
        }

        return res;
    }

    private int buyAnyTimes(int[] nums){
        int ans = 0;
        for (int i = 1; i < nums.length; i ++){
            ans += Math.max(nums[i] - nums[i - 1], 0);
        }

        return ans;
    }
}
