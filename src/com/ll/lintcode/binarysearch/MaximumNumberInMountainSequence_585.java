package com.ll.lintcode.binarysearch;

/**
 * 给 n 个整数的山脉数组，即先增后减的序列，找到山顶（最大值）
 *
 * 样例
 * 例1:
 *
 * 输入: nums = [1, 2, 4, 8, 6, 3]
 * 输出: 8
 * 例2:
 *
 * 输入: nums = [10, 9, 8, 7],
 * 输出: 10
 * 注意事项
 * 数组严格递增，严格递减
 */
public class MaximumNumberInMountainSequence_585 {

    public int mountainSequence(int[] nums) {
        if (nums == null || nums.length < 1){
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] < nums[mid + 1]){
                start = mid + 1;
            }else{
                end = mid;
            }
        }

        return Math.max(nums[start], nums[end]);
    }

}
