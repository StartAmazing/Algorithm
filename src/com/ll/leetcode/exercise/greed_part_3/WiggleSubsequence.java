package com.ll.leetcode.exercise.greed_part_3;

import java.util.Vector;

/**
 *
 * 2、摇摆序列
 *
 * 一个整数序列，如果两个相邻元素的差正好正负（负正）交替出现，则该序列被称为摇摆序列，
 * 一个小于2个元素的序列直接为摇摆序列，2个元素时这两个元素不相等时为摇摆序列(要么用前
 * 一个元素减后一个元素，要么都用后一个元素减去前一个元素)
 * 例如：
 * 序列[1,7,4,9,2,5],相邻元素的差（6,-3,5,-7,,3），该序列为摇摆序列
 * 序列[1,4,7,2,5](3,3,-5,3)、[1,7,4,5,5](6,-3,1,0)不是摇摆序列
 *
 * 给一个随机序列，求这个序列满足摇摆序列定义的最长子序列的长度
 * 例如:
 * 输入[1,7,4,9,2,5],结果为6；输入[1,17,5,10,13,15,10,5 ,16,8]，结果为7([1,17,5,10,13,15,10])
 * ;输入[1,2,3,4,5,6,7,8,9],结果为2
 *
 *      leetCode 376
 *      It's Medium
 */
public class WiggleSubsequence {
    private static int wiggleMaxLength(Vector<Integer> nums){
        if(nums.size() < 2){    //序列个数小于2时直接为摇摆序列
            return nums.size();
        }
        final int BEGIN = 0;
        final int UP = 1;
        final int DOWN = 2;     //定义序列的三种状态

        int state = BEGIN;     //初识状态
        int max_length = 1; //摇摆序列的最大长度至少为1
        //从序列的第二个元素开始扫描
        for(int i = 1; i < nums.size(); i++){
            switch (state){
                case BEGIN:
                    if(nums.get(i - 1) < nums.get(i)){
                        state = UP;
                        max_length ++;
                    }else{
                        state = DOWN;
                        max_length ++;
                    }
//                    System.out.println(nums.get(i-1));
                    break;
                case UP:
                    if(nums.get(i - 1) > nums.get(i)){
                        state = DOWN;
                        max_length ++;
//                        System.out.println(nums.get(i-1));
                    }
                    break;
                case DOWN:
                    if(nums.get(i - 1) < nums.get(i)){
                        state = UP;
                        max_length ++;
//                        System.out.println(nums.get(i-1));
                    }
                    break;
            }
        }

        return max_length;
    }

    public static void main(String[] args) {
        Vector<Integer> nums = new Vector<>();
        nums.add(1);
        nums.add(17);
        nums.add(5);
        nums.add(10);
        nums.add(13);
        nums.add(15);
        nums.add(10);
        nums.add(5);
        nums.add(16);
        nums.add(8);
        System.out.println(wiggleMaxLength(nums));
    }


}
