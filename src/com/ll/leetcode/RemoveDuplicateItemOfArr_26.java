package com.ll.leetcode;

/**
 * Created by LL on 2019/9/26.
 */
public class RemoveDuplicateItemOfArr_26 {

    private static int removeDeplicates(int[] nums){
        int i = 0;
        for(int j = 0; j < nums.length; j ++){
            if(nums[i] != nums[j]){
                i ++;
                nums[i] = nums[j];
            }
        }
        int[] arr = new int[i+1];
        for(int m = 0; m <= i; m ++){
            arr[m] = nums[m];
        }

        return arr.length;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,0,0,1,2,2,3,4,4,5};
        System.out.println(removeDeplicates(arr));
    }

}
