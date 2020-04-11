package com.ll.lintcode.dp.chapter3;

/**
 * 给定一个数组 prices 表示一支股票每天的价格.
 *
 * 你可以完成任意次数的交易, 不过你不能同时参与多个交易 (也就是说, 如果你已经持有这支股票, 在再次购买之前, 你必须先卖掉它).
 *
 * 设计一个算法求出最大的利润.
 *
 * 样例
 * 样例 1:
 *
 * 输入: [2, 1, 2, 0, 1]
 * 输出: 2
 * 解释:
 *     1. 在第 2 天以 1 的价格买入, 然后在第 3 天以 2 的价格卖出, 利润 1
 *     2. 在第 4 天以 0 的价格买入, 然后在第 5 天以 1 的价格卖出, 利润 1
 *     总利润 2.
 * 样例 2:
 *
 * 输入: [4, 3, 2, 1]
 * 输出: 0
 * 解释: 不进行任何交易, 利润为0.
 */
public class BestTimeToBuyAndSellStock_II_150 {

    public int maxProfit(int[] prices) {
        if (null == prices || prices.length < 1){
            return 0;
        }

        int res = 0;
        for (int i = 1; i < prices.length; i ++){
            res += (prices[i] > prices[i - 1] ? prices[i] - prices[i - 1] : 0);
        }

        return res;
    }

}
