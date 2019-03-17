package com.ll.leetcode;

import com.ll.muke.SegmentTree.SegmentTree;

public class NumArray_303 {

    private SegmentTree<Integer> segmentTree;

    public NumArray_303(int[] nums){

        if(nums.length > 0){
            Integer[] data = new Integer[nums.length];
            for(int i = 0; i < nums.length; i++ ){
                data[i] = nums[i];
            }
            segmentTree = new SegmentTree<>(data, (a, b) -> (a + b));
        }
    }
    public int sumRange(int i,int j){
        if(segmentTree == null){
            throw new IllegalArgumentException("Illegal Data!");
        }
        return segmentTree.query(i,j);
    }


}
