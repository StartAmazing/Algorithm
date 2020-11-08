package com.ll.lintcode.dp.chapter2;

/**
 * 给定一个整数数组（下标从 0 到 n-1， n 表示整个数组的规模），请找出该数组中的最长上升连续子序列。
 * （最长上升连续子序列可以定义为从右到左或从左到右的序列。）
 *
 * 样例
 * 样例 1：
 * 输入：[5, 4, 2, 1, 3]
 * 输出：4
 * 解释：
 * 给定 [5, 4, 2, 1, 3]，其最长上升连续子序列（LICS）为 [5, 4, 2, 1]，返回 4。
 *
 *
 * 样例 2：
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
        if (A.length == 1) {
            return 1;
        }
        int ans1 = LICS(A);
        int left = 0, right = A.length - 1;
        while (left < right) {
            int temp = A[left];
            A[left] = A[right];
            A[right] = temp;
            left++;
            right--;
        }
        int ans2 = LICS(A);

        return Math.max(ans1, ans2);
    }

    private int LICS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ans = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
