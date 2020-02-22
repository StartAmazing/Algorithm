package com.ll.lintcode.twopoint;

import java.util.Arrays;

public class TwoSumMoreThanOrEqualThanTarget_x {

    public int towSum(int[] nums, int target){
        if(nums == null || nums.length < 2){
            return 0;
        }
        int count = 0;
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l < r){
            if (nums[l] + nums[r] >= target){
                count += r - l;
                r --;
            }else{
                l ++;
            }
        }
        return count;
    }
}
