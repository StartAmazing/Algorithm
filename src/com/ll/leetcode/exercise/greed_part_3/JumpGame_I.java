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
 * 若此时处在第i个位置，该位置最远可以跳至第j个位置（index[j]）、故第i个位置还可以跳至;
 * 第i+1、i+2、...、j-1、j位置中可以跳的更远位置的位置，即index[i+1]、index[i+2]、...
 * index[j-1]、index[j]最大的那个！
 *
 * 原因：假设该位置为x，index[x]最大，故从位置x出发，可以跳至i+1、i+2、...、j-1、j所有
 * 位置位置可以达到的位置；所以跳至位置x最为理想
 *
 * 算法思路：
 *     1、求从第i个位置最远可跳至第index[i]位置；根据从第i位置最远可跳nums[i]步，
 *        index[i] = i + nums[i]
 *     2、初始化；
 *        1）、设置变量jump代表当前所处的位置，初始化为0；
 *        2）、设置变量max_index代表从第0个位置至jump位置这个过程中，最远可到达的位置；
 *        3）、利用jump扫描数组，知道jump达到数组尾部或超过max_index，扫描过程中更新max_index；
 *        4）、若最终jump为数组长度，则返回true，否则返回false.
 *
 *  LeetCode 55 Jump Game
 *  It's Medium
 *
 */
public class JumpGame_I {

    private static boolean canJump(Vector<Integer> nums){

        if (nums == null || nums.size() < 2){
            throw new RuntimeException("Illegal Array of nums!");
        }
        int jump = 0;
        int max_index = 0;
        Vector<Integer> index = new Vector<>();

        for(int i = 0; i < nums.size(); i++){
            index.add(i,i + nums.get(i));
        }

//        while(jump < index.size() - 1){  //!!!!!!!!!!!!!!!!!!!!!!!!!!!!不能遍历到最后一个元素
        while(jump < index.size() && jump <= max_index){
            if(max_index < index.get(jump)){
                max_index = index.get(jump);
            }
            jump ++;
        }

        return max_index >= nums.size() - 1;

    }

    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        vector.add(2);
        vector.add(3);
        vector.add(1);
        vector.add(1);
        vector.add(4);
        System.out.println(canJump(vector));
        Vector<Integer> vector2 = new Vector<>();
        vector2.add(3);
        vector2.add(2);
        vector2.add(1);
        vector2.add(0);
        vector2.add(4);
        System.out.println(canJump(vector2));
    }

}
