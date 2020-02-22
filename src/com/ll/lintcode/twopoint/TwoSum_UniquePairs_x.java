package com.ll.lintcode.twopoint;

import java.util.Arrays;

/**
 * 找到排序数组中所有的组合之和为目标值的数量，去重
 */
public class TwoSum_UniquePairs_x {

    public int twoSum(int[] nums, int target){
        if(nums == null || nums.length < 2){
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        int l = 0;
        int r = nums.length - 1;
        while (l < r){
            if(nums[l] + nums[r] == target){
                count ++;
                l ++;
                r --;
                while (l < r && nums[l] == nums[l - 1]){
                    l ++;
                }
                while (l < r && nums[r] == nums[r + 1]){
                    r --;
                }
            }else if(nums[l] + nums[r] > target){
                r --;
            }else{
                l ++;
            }
        }
        return count;
    }
}
