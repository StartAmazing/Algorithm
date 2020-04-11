package com.ll.lintcode.dp.chapter1;

/**
 * 给出一个非负整数数组，你最初定位在数组的第一个位置。　　　
 *
 * 数组中的每个元素代表你在那个位置可以跳跃的最大长度。　　　　
 *
 * 判断你是否能到达数组的最后一个位置。
 *
 * 样例
 * 样例 1
 *
 * 输入 : [2,3,1,1,4]
 * 输出 : true
 * 样例 2
 *
 * 输入 : [3,2,1,0,4]
 * 输出 : false
 * 注意事项
 * 这个问题有两个方法，一个是贪心和 动态规划。
 *
 * 贪心方法时间复杂度为O（N）。
 *
 * 动态规划方法的时间复杂度为为O（n^2）。
 *
 * 我们手动设置小型数据集，使大家可以通过测试的两种方式。
 * 这仅仅是为了让大家学会如何使用动态规划的方式解决此问题。
 * 如果您用动态规划的方式完成它，你可以尝试贪心法，以使其再次通过一次。
 */
public class JumpGame_116 {

    public boolean canJump(int[] nums){
        if (nums == null || nums.length < 1){
            return false;
        }
        if (nums.length == 1){
            return true;
        }
        //dp[i] 表示能不能跳到f[i]
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 1; i < dp.length; i ++){
            //previous stone i before j
            //last jump from i to j
            for(int j = 0; j < i; j ++){
                if (nums[j] + j >= i && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length - 1];
    }
}
