package com.ll.lintcode.dp.chapter3;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * 假设你有一个数组，它的第i个元素是一支给定的股票在第i天的价格。设计一个算法来找到最大的利润。你最多可以完成两笔交易。
 *
 * 样例
 * 样例 1
 *
 * 输入 : [4,4,6,1,1,4,2,5]
 * 输出 : 6
 * 注意事项
 * 你不可以同时参与多笔交易(你必须在再次购买前出售掉之前的股票)
 */
public class BestTimeToBuyAndSellStock_III_151 {

    public int maxProfit(int[] prices) {
         if (null == prices || prices.length < 1){
             return 0;
         }

         //dp[i][j]表示前i天（第i - 1天）结束后，在阶段j的最大获利
         int[][] dp = new int[prices.length + 1][5 + 1];
         int i, j;

         //init
        dp[0][1] = 0;
        for (i = 2;i < 6; i++){
            dp[0][i] = Integer.MIN_VALUE;
        }

        for (i = 1; i <= prices.length; ++i){
            //phase 1, 3, 5
            for (j = 1; j < 6; j += 2){
                dp[i][j] = dp[i - 1][j];
                if (j > 1 && dp[i - 1][j - 1] != Integer.MIN_VALUE){
                    //当前已经处于阶段3
                    //当前处于阶段2，要变成阶段3
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + prices[i - 1] - prices[i - 2]);
                }
            }

            //phase 2, 4
            for (j = 2; j < 6; j += 2){
                dp[i][j] = dp[i - 1][j - 1];
                if (dp[i - 1][j] != Integer.MIN_VALUE){
                    //当前处在阶段1 ，现在要变成阶段2
                    //当前是处在阶段2， 每天计算增加收益即可
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + prices[i - 1]- prices[i - 2]);
                }
            }
        }

        return Math.max(dp[dp.length - 1][1], Math.max(dp[dp.length -1][3], dp[dp.length - 1][5]));
    }

}
