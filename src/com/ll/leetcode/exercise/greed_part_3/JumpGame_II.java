package com.ll.leetcode.exercise.greed_part_3;

import java.util.Vector;

/**
 * 题目描述：
 *      一个数组存储了非负整型数据，数组中第i个元素nums[i],代表了可以从数组第i个位置
 *      最多向前跳跃nums[i]步;已知数组各元素的情况下，确认可以从0位置跳跃到数组的最后
 *      一个位置，求最少需要跳跃几次?
 *
 * 例如：
 *      nums = [2,3,1,1,4],从第0位置跳到第1位置，从第1位置跳至最后一个位置，一共两次。
 *
 * 思考：
 *      从0位置，最少需要跳几次达到最后一个位置？
 *      如果希望最少跳跃达到终点，则需要明确何时进行跳跃是最合适。
 *
 *      不管是提早跳跃还是说在可跳跃最大位置i之前跳跃都有可能增加跳跃次数。
 * 贪心规律：
 *      在到达某点前若一直不跳跃，发现从该点不能跳到更远的地方了，在这之前肯定有次必要
 *      的跳跃。
 *      结论：在无法到达更远的地方时，在这之前应该跳到一个可以达到更远位置的位置！
 * 算法思路：
 *      1、设置current_max_index为当前可以达到的最远位置；
 *      2、设置pre_max_max_index为在遍历各个位置的过程中，各个位置可以达到的最远位置；
 *      3、设置jump_min为最少跳跃的次数；
 *      4、利用i遍历nums数组，若i超过current_max_index，jump_min加一，current_max_index=pre_max_max_index;
 *      5、遍历过程中，若nums[i] + i(index[i])更大，则更新pre_max_max_index=nums[i] + i
 *
 *      LeetCode 45 JumpGame_II
 *      It's hard
 */
public class JumpGame_II {

    public static int jumpTimes(Vector<Integer> nums){

        if(nums.size() < 2){
            return 0;           //如果数组的长度小于2，则说明不用跳跃，返回0
        }

        int current_max_index = nums.get(0);    //当前可达到的最远位置
        int pre_max_max_index = 0;      //即更新当前可达到的最远位置
        int jum_min = 1;

        for(int i = 1; i < nums.size(); i++){
            if(i > current_max_index){      //若无法再向前移动了，才进行跳跃
                jum_min ++;
                current_max_index = pre_max_max_index;
            }
            //循环遍历时顺便记录其中能跳到最远处的下标值
            if(pre_max_max_index < nums.get(i) + i){
                pre_max_max_index = nums.get(i) + i;    //更新pre_max_max_index
            }
        }
        return jum_min;
    }

    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        vector.add(2);
        vector.add(3);
        vector.add(1);
        vector.add(1);
        vector.add(4);
        System.out.println(jumpTimes(vector));
    }

}
