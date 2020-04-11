package com.ll.lintcode.advance.chapter1.twopoint;

/**
 * 给定一个由 n 个正整数组成的数组和一个正整数 s ，请找出该数组中满足其和 ≥ s 的最小长度子数组。如果无解，则返回 -1。
 *
 * 样例
 * 样例 1:
 *
 * 输入: [2,3,1,2,4,3], s = 7
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的最小长度子数组。
 * 样例 2:
 *
 * 输入: [1, 2, 3, 4, 5], s = 100
 * 输出: -1
 * 挑战
 * 如果你已经完成了O(nlogn)时间复杂度的编程，请再试试 O(n)时间复杂度。
 */
public class MinimumSize_406 {

    public int minimumSize(int[] nums, int s){
        int i, j = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        for (i = 0; i < nums.length; i++){
            while (j < nums.length && sum < s){
                sum += nums[j ++];
            }

            if (sum >= s){
                ans = Math.min(sum, j - i);
            }

             sum -= nums[i];
        }

        if (ans == Integer.MAX_VALUE){
            return -1;
        }

        return ans;
    }

}
