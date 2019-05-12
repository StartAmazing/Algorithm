package com.ll.leetcode.exercise.greed_part_3;

import java.util.Vector;

/**
 *
 * 一个数组存储了非负整型数据，数组的第i个元素nums[i],代表了可以从数组第i个位置最多向前
 * 跳跃nums[i]步，已知数组各元素的情况下，求是否可以从数组的第0个位置跳跃到数组的最后一
 * 个元素的位置？
 *
 * 例如：nums[2,3,1,1,4],可以从nums[0] = 2 跳跃至nums[4] = 4
 *       nums[3,2,1,0,4],不可以从nums[0] = 3 跳跃至nums[4] = 4
 *
 * 从第i个位置，最远可跳nums[i]步
 * nums = [2,3,1,1,4,...]
 * 确定最终是否可以跳跃至最后一个位置，最困难的地方在于：
 * 无法直观的观察出从第0个位置开始依次向后的跳跃方式
 *
 * 从第i个位置，最远可以跳nums[i]步：
 * nums = [2,3,1,1,4,...]
 * 从第i个位置，最远可跳至第index[i]个位置：
 * 即index[i] = i + nums[i];
 * index = [2,4,3,4,8,...]
 * 若从第0位置也一定可以跳至：
 * 第一个位置、第二个位置、...、第i - 1个位置
 * 从第0个位置，应该跳至第1、第2、...、第i - 1、第i个位置中的哪个？
 * 应该跳至第1、2、...、i-1、i位置中，又可向前跳至更远位置
 * （即index[1]、index[2]、...、index[i - 1]、...index[i]最大的那个）的位置！（贪心）
 *
 *  LeetCode 55 Jump Game
 *  It's Medium
 *
 */
public class JumpGame_I {

    private static boolean canJump(Vector<Integer> nums){


        return false;
    }

    public static void main(String[] args) {

    }

}
