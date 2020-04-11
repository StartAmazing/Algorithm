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
 */
public class LongestIncreasingSubsequence_76 {

    public int longestIncreasingSubSquence(int[] nums) {
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

    /**
     * 子数组
     * @param nums
     * @return
     */
    public int longestIncreasingContinousSubsequence(int[] nums){
        if (null == nums || nums.length < 1){
            return 0;
        }

        int r1 = LICS(nums);
        int i = 0, j = nums.length - 1, tmp;
        while (i < j){
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i ++;
            j --;
        }

        int r2 = LICS(nums);

        return Math.max(r1, r2);
    }

    private int LICS(int[] nums) {
        if (null == nums || nums.length < 1){
            return 0;
        }
        int[] dp = new int[nums.length];
        int res = 1;
        for (int i = 0; i < nums.length; i ++){
            //case 1
            dp[i] = 1;

            //case 2
            if (i > 0 && nums[i] > nums[i - 1]){
                dp[i] = dp[i - 1] + 1;
            }

            res = Math.max(res, dp[i]);
        }

        return res;
    }
}