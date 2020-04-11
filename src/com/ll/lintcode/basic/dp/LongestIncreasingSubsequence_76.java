package com.ll.lintcode.basic.dp;

import java.util.Arrays;

/**
 * 给定一个整数序列，找到最长上升子序列（LIS），返回LIS的长度。
 * <p>
 * 样例
 * 样例 1:
 * 输入:  [5,4,1,2,3]
 * 输出:  3
 * <p>
 * 解释:
 * LIS 是 [1,2,3]
 * <p>
 * <p>
 * 样例 2:
 * 输入: [4,2,4,5,3,7]
 * 输出:  4
 * <p>
 * 解释:
 * LIS 是 [2,4,5,7]
 * 挑战
 * 要求时间复杂度为O(n^2) 或者 O(nlogn)
 * <p>
 * 说明
 * 最长上升子序列的定义：
 * <p>
 * 最长上升子序列问题是在一个无序的给定序列中找到一个尽可能长的由低到高排列的子序列，这种子序列不一定是连续的或者唯一的。
 * https://en.wikipedia.org/wiki/Longest_increasing_subsequence
 */
public class LongestIncreasingSubsequence_76 {

    //sub sequence VS sub array

    //A: f[i] = 以第i个位置结尾的LIS √
    //B: f[i] = "前"i个数里的LIS ×

    public int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int[] f = new int[nums.length];
        Arrays.fill(f, 1);

        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < i; j ++){
                if (nums[j] < nums[i]){
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }

        int best = Integer.MIN_VALUE;
        for (int i = 0; i < f.length; i++){
            best = Math.max(f[i], best);
        }

        return best;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence_76 dto = new LongestIncreasingSubsequence_76();
        // 1,1,2,2,3
        int[] data = new int[]{9, 3, 6, 2, 7};
        dto.longestIncreasingSubsequence(data);
    }
}
