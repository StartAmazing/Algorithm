package com.ll.zs.basic.mytest;

import java.util.List;

/**
 * 给定一个旋转排序数组，在原地恢复其排序。（升序）
 *
 * 样例
 * Example1:
 * [4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]
 * Example2:
 * [6,8,9,1,2] -> [1,2,6,8,9]
 *
 * 挑战
 * 使用O(1)的额外空间和O(n)时间复杂度
 *
 * 说明
 * 什么是旋转数组？
 *
 * 比如，原始数组为[1,2,3,4], 则其旋转数组可以是[1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]
 */
public class RecoverRotateArray {
    public void recoverRotatedSortedArray(List<Integer> nums) {
        int index = 0;
        for(int i = 1 ;i < nums.size(); i ++){
            if(nums.get(i) < nums.get(i - 1)){
                reverse(index,i - 1, nums);
                reverse(i , nums.size() -1 ,nums);
                reverse(index, nums.size() - 1, nums);
            }
        }
    }

    public void reverse(int start, int end, List<Integer> nums){
        int l = start;
        int r = end;
        while(l < r){
            Integer tmp = nums.get(l);
            nums.set(l, nums.get(r));
            nums.set(r, tmp);
            l ++;
            r --;
        }
    }

}
