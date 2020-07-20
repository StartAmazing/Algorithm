package com.ll.lintcode.advance.chapter4.binarysearch;

/**
 * 有一些原木，现在想把这些木头切割成一些长度相同的小段木头，需要得到的小段的数目至少为 k。当然，
 * 我们希望得到的小段越长越好，你需要计算能够得到的小段木头的最大长度。
 *
 * 木头长度的单位是厘米。原木的长度都是正整数，我们要求切割得到的小段木头的长度也要求是整数。
 * 无法切出要求至少 k 段的,则返回 0 即可。
 *
 * 您在真实的面试中是否遇到过这个题？
 * 样例
 * 样例 1
 *
 * 输入:
 * L = [232, 124, 456]
 * k = 7
 * 输出: 114
 * Explanation: 我们可以把它分成114cm的7段，而115cm不可以
 * 样例 2
 *
 * 输入:
 * L = [1, 2, 3]
 * k = 7
 * 输出: 0
 * 说明:很显然我们不能按照题目要求完成。
 * 挑战
 * O(n log Len), Len为 n 段原木中最大的长度
 *
 * Last/Biggest length that can  get >= k pieces
 */
public class WoodCut_183 {

    public int woodCut(int[] L, int k) {
        if (null == L || L.length < 1) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < L.length; i++) {
            sum += L[i];
        }

        if (sum / k < 1) {
            return 0;
        }

        int max = findMax(L);

        int start = 1;
        int end = max;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            int partSum = 0;
            for (int i = 0; i < L.length; i++) {
                partSum += L[i] / mid;
            }

            if (partSum >= k) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return start;
    }

    private int findMax(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans = Math.max(nums[i], ans);
        }

        return ans;
    }

}
