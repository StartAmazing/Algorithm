package com.ll.lintcode.dp.chapter1;

/**
 * 给出不同面额的硬币以及一个总金额. 写一个方法来计算给出的总金额可以换取的最少的硬币数量.
 * 如果已有硬币的任意组合均无法与总金额面额相等, 那么返回 -1.
 *
 * 样例
 * 样例1
 *
 * 输入：
 * [1, 2, 5]
 * 11
 * 输出： 3
 * 解释： 11 = 5 + 5 + 1
 * 样例2
 *
 * 输入：
 * [2]
 * 3
 * 输出： -1
 * 注意事项
 * 你可以假设每种硬币均有无数个
 *
 * 求最大最小值的动态规划
 */
public class CoinChange_669 {

    public int coinChange(int[] coins, int amount){
        int n = coins.length;
        int[] f = new int[coins.length + 1];
        f[0] = 0;
        int i, j;
        for (i = 1; i <= amount; i ++){
            f[i] = Integer.MAX_VALUE;
            for (j = 0; j < n; ++ j){
                if (i >= coins[j] && f[i - coins[j]] != Integer.MAX_VALUE){
                    f[i] =  Math.min(f[i], f[i - coins[j]] + 1);
                }
            }
        }
        if (f[amount] == Integer.MAX_VALUE){
            return  -1;
        }
        return f[amount];
    }
}
