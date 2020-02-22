package com.ll.lintcode.twopoint;

import java.util.Arrays;

/**
 * 求两数之和中尽量接近target的和的值
 */
public class TwoSumClosest_x {

    public int twoSum(int[] nums, int target){
        if (nums == null || nums.length < 2){
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        int best = Integer.MAX_VALUE;
        int l = 0;
        int r = nums.length - 1;
        while (l < r){
            int diff = Math.abs(nums[l] + nums[r] - target);
            best = Math.min(best, diff);
            if(nums[l] + nums[r] < target){
                l ++;
            }else{
                r ++;
            }
        }
        return best;
    }

}
