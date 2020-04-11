package com.ll.lintcode.dp.chapter3;

/**
 * 在上次打劫完一条街道之后，窃贼又发现了一个新的可以打劫的地方，但这次所有的房子围成了一个圈，
 * 这就意味着第一间房子和最后一间房子是挨着的。每个房子都存放着特定金额的钱。你面临的唯一约束条件是：
 * 相邻的房子装着相互联系的防盗系统，且 当相邻的两个房子同一天被打劫时，该系统会自动报警。
 *
 * 给定一个非负整数列表，表示每个房子中存放的钱， 算一算，如果今晚去打劫，在不触动报警装置的情况下, 你最多可以得到多少钱 。
 *
 * 样例
 * 样例1
 *
 * 输入: nums = [3,6,4]
 * 输出: 6
 * 样例2
 *
 * 输入: nums = [2,3,2,3]
 * 输出: 6
 * 注意事项
 * 这题是House Robber的扩展，只不过是由直线变成了圈
 */
public class HouseRobber_II_534 {

    public int houseRobber2(int[] nums) {
        if(null == nums || nums.length < 1){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        // write your code here
        int[] withoutStart = new int[nums.length - 1];
        int[] withoutEnd = new int[nums.length - 1];
        System.arraycopy(nums, 0, withoutStart, 0, withoutStart.length);
        System.arraycopy(nums, 1, withoutEnd, 0, withoutEnd.length);

        return Math.max(calc(withoutStart), calc(withoutEnd));
    }

    private int calc(int[] nums){
        if(null == nums || nums.length < 1){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[2];
//        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < nums.length + 1; i ++){
            int tmp = Math.max(dp[1], dp[0] + nums[i - 1]);
            dp[0] = dp[1];
            dp[1] = tmp;
        }

        return dp[1];
    }
}
