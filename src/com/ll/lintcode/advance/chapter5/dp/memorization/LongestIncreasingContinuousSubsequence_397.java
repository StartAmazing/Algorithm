package com.ll.lintcode.advance.chapter5.dp.memorization;

/**
 * 给定一个整数数组（下标从 0 到 n-1， n 表示整个数组的规模），请找出该数组中的最长上升连续子序列。（最长上升连续子序列可以定义为从右到左或从左到右的序列。）
 *
 * 样例
 * 样例 1：
 *
 * 输入：[5, 4, 2, 1, 3]
 * 输出：4
 * 解释：
 * 给定 [5, 4, 2, 1, 3]，其最长上升连续子序列（LICS）为 [5, 4, 2, 1]，返回 4。
 * 样例 2：
 *
 * 输入：[5, 1, 2, 3, 4]
 * 输出：4
 * 解释：
 * 给定 [5, 1, 2, 3, 4]，其最长上升连续子序列（LICS）为 [1, 2, 3, 4]，返回 4。
 * 挑战
 * 使用 O(n) 时间和 O(1) 额外空间来解决
 */
public class LongestIncreasingContinuousSubsequence_397 {

    public int longestIncreasingContinuousSubsequence(int[] A) {
        if (A == null || A.length < 1) {
            return 0;
        }

        int[] reverse = new int[A.length];
        int j = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            reverse[i] = A[j++];
        }

        return Math.max(getLIST(A), getLIST(reverse));
    }

    private int getLIST(int[] nums) {
        int[] dp = new int[nums.length];
        int ans = 1;
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                int tmp = nums[j] < nums[i] ? dp[j] + 1 : dp[i];
                dp[i] = Math.max(tmp, dp[i]);
            }
            ans = Math.max(dp[i], ans);
        }

        return ans;
    }
}
