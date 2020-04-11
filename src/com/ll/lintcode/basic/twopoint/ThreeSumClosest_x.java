package com.ll.lintcode.basic.twopoint;

import java.util.Arrays;

/**
 * 找到数组中三个数的和最接近目标值的那个和的值
 */
public class ThreeSumClosest_x {

    public int threeSumClosest(int[] nums, int target){
        if (nums == null || nums.length < 3){
            return -1;
        }
        Arrays.sort(nums);
        int best = nums[0] + nums[1] + nums[2];
        for (int i = 0;  i < nums.length - 2;  i++){
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(Math.abs(sum - target) < Math.abs(best - target)){
                    best = sum;
                }
                if(sum < target){
                    l ++;
                }else {
                    r --;
                }
            }
        }
        return best;
    }




}
