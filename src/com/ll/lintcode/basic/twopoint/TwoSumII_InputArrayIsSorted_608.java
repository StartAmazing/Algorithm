package com.ll.lintcode.basic.twopoint;

/**
 * 给定一个已经 按升序排列 的数组，找到两个数使他们加起来的和等于特定数。
 * 函数应该返回这两个数的下标，index1必须小于index2。注意返回的值不是 0-based。
 */
public class TwoSumII_InputArrayIsSorted_608 {
    /**
     * @param nums: an array of Integer
     * @param target: target = nums[index1] + nums[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            if(nums[left] + nums[right] == target){
                return new int[]{left + 1, right + 1};
            }else if(nums[left] + nums[right] < target){
                left ++;
            }else if(nums[left] + nums[right] > target){
                right --;
            }
        }

        return null;
    }


}
