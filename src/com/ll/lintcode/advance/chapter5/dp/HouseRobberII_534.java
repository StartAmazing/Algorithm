package com.ll.lintcode.advance.chapter5.dp;

/**
 * 在上次打劫完一条街道之后，窃贼又发现了一个新的可以打劫的地方，但这次所有的房子围成了一个圈，这就意味着第一间房子和最后一间房子是挨着的。每个房子都存放着特定金额的钱。你面临的唯一约束条件是：相邻的房子装着相互联系的防盗系统，且 当相邻的两个房子同一天被打劫时，该系统会自动报警。
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
public class HouseRobberII_534 {

    // 对于循环数组
    // 1. 分裂
    // 2. 重复
    // 3. 取反
    public int houseRobber2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int[] withoutEnd = new int[nums.length - 1];
        int[] withoutStart = new int[nums.length - 1];
        System.arraycopy(nums, 0, withoutEnd, 0, nums.length - 1);
        System.arraycopy(nums, 1, withoutStart, 0, nums.length - 1);

        return Math.max(calc(withoutEnd), calc(withoutStart));
    }

    private int calc(int[] nums) {
        int[] dp = new int[2];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i % 2] = Math.max(dp[(i - 1) % 2], dp[(i - 2) % 2] + nums[i]);
        }
        return dp[(nums.length - 1) % 2];
    }
}
