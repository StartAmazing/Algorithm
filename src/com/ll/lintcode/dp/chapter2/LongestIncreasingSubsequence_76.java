package com.ll.lintcode.dp.chapter2;

/**
 * 给定一个整数序列，找到最长上升子序列（LIS），返回LIS的长度。
 *
 * 样例
 * 样例 1:
 * 	输入:  [5,4,1,2,3]
 * 	输出:  3
 *
 * 	解释:
 * 	LIS 是 [1,2,3]
 *
 *
 * 样例 2:
 * 	输入: [4,2,4,5,3,7]
 * 	输出:  4
 *
 * 	解释:
 * 	LIS 是 [2,4,5,7]
 * 挑战
 * 要求时间复杂度为O(n^2) 或者 O(nlogn)
 *
 * 说明
 * 最长上升子序列的定义：
 *
 * 最长上升子序列问题是在一个无序的给定序列中找到一个尽可能长的由低到高排列的子序列
 *
 *
 * 思路：
 * 1. 动态规划第一步： 确定状态；
 *    - 最后一步： 对于最优策略，一定有最后一个元素a[j]
 *    - 第一种情况：最有策略中最长连续上升子序列就是{a[j]},答案是1
 *    - 第二种情况：子序列长度大于1， 那么最有策略就是a[j]前一个元素肯定是a[j - 1],这种情况a[j - 1] < a[j]
 *    - 因为是最优策略，那么它选中的以a[j - 1]结尾的连续上升子序列一定是最长的
 *    - 要求以a[j - 1]结尾的最长连续上升子序列
 *    - 本来是求以a[j]结尾的最长连续上升子序列
 *    - 化为子问题
 *    - 状态：设 f[j] = 以 a[j] 结尾的最长上升子序列的长度
 * 2. 动态规划第二步： 转移方程；
 *    - f[i] = 以 a[j] 结尾的最长上升子序列的长度
 *      f[i] = max{1, f[i - 1] + 1 | j > 0 and a[j - 1] < a[j]}
 * 3. 动态规划第三步： 初始条件和边界情况
 *    - 情况2 必须满足：
 *          - j > 0, 即 a[i] 前面至少还有一个元素
 *          - a[j] > a[j - 1], 满足单调性
 *    - 初始条件： 空 / f[0] = 1
 * 4. 动态规划第四步： 计算顺序；
 *     - 计算f[0], f[1], f[2] ... f[n - 1];
 *     - 因为我们不知道最优策略中的最后一个元素是哪个a[j],所以答案是
 *              max{f[0], f[1], f[2] ... f[n - 1]}
 *     - 算法时间复杂度为O(n) 空间复杂度为O(n)
 *
 */
public class LongestIncreasingSubsequence_76 {

    public int longestIncreasingSubSequence(int[] nums) {
        if (null == nums || nums.length < 1) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int ans = 1;
        for (int value : dp) {
            ans = Math.max(ans, value);
        }
        return ans;
    }
}