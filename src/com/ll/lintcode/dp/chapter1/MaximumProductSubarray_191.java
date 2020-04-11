package com.ll.lintcode.dp.chapter1;

/**
 * 找出一个序列中乘积最大的连续子序列（至少包含一个数）。
 *
 * 样例
 * 样例 1:
 *
 * 输入:[2,3,-2,4]
 * 输出:6
 * 样例 2:
 *
 * 输入:[-1,2,4,1]
 * 输出:8
 * 注意事项
 * 乘积最大的子序列的积，小于2147483647
 */
public class MaximumProductSubarray_191 {

    /**
     * 步骤1：确定状态
     * 最后一步：对于最优策略（乘积最大），一定有最后一个元素a[j]
     * 第一种情况：最优策略的序列就是{a[j]}，答案是a[j]
     * 第二种情况，连续子序列长度大于1，那么最优策略中a[j]前一个元素肯定是a[j - 1]
     * 但是如果a[j]是正数，我们希望以a[j - 1]结尾的连续子序列乘积最大；但是如果a[j]
     * 是负数，我们希望以a[j - 1]结尾的连续子序列成绩最小
     * 所以题目要求最大，我们需要同时保留以a[j - 1]结尾最小和最大的乘积
     *       子问题
     *       可以同时做到两个问题：求以a[j]结尾的连续子序列的最大乘积和以a[j]结尾的
     *       乘积最打/小连续子序列
     *       化为子问题
     *       状态：设f[i] = 以a[j]结尾的连续子序列的最大乘积，设g[j] = 以a[j]结尾
     *       的连续子序列的最小乘积
     *
     * 步骤2：转移方程
     *        f[i] = 以a[i]结尾的连续子序列的最大乘积
     *        f[i] = max{a[i], max{a[i] * f[i - 1], a[i] * g[i - 1]}  | i > 0}
     *        g[j] = 以a[j]结尾的连续子序列的最小乘积
     *        g[j] = min{a[j], min{a[j] * f[j - 1], a[j] * g[j - 1]}  | j > 0}
     *
     * 步骤3：初始条件和边界情况
     *        f[0] = a[0]
     *        g[0] = a[0]
     *        也相当于没有初始条件
     * 步骤4：计算顺序
     *        f[i] = 以a[i]结尾的连续子序列中的最大乘积
     *        g[i] = 以a[i]结尾的连续子序列中的最小乘积
     *        计算顺序是f[0], g[0], f[1], g[1], ... ,f[n - 1],g [n - 1]
     *        答案是max{f[0], f[1], ... , f[n - 1]}
     *
     */
    public int maxProduct(int[] num){
        if (num == null || num.length < 1){
            return 0;
        }
        int[] f = new int[num.length];
        int[] g = new int[num.length];
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < num.length; i ++){
            f[i] = num[i];
            g[i] = num[i];
            if (i > 0){
                f[i] = Math.max(num[i], Math.max(f[i - 1] * num[i], g[i - 1] * num[i]));
                g[i] = Math.min(num[i], Math.min(g[i - 1] * num[i], f[i - 1] * num[i]));
            }

            ans = Math.max(ans, f[i]);
        }

        return ans;
    }
}
