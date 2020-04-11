package com.ll.lintcode.basic.twopoint;

/**
 * 移除掉数组中重复的元素
 */
public class RemoveDuplicateNumbersInArray_x {
    public int deduplication(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }

        int index = 0;
        for(int i = 0;i < nums.length; i++){
            if(nums[i] != nums[index]){
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }


}
