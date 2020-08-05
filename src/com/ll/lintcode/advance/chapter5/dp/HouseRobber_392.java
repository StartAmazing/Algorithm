package com.ll.lintcode.advance.chapter5.dp;

/**
 * 假设你是一个专业的窃贼，准备沿着一条街打劫房屋。每个房子都存放着特定金额的钱。你面临的唯一约束条件是：
 * 相邻的房子装着相互联系的防盗系统，且 当相邻的两个房子同一天被打劫时，该系统会自动报警。
 *
 * 给定一个非负整数列表，表示每个房子中存放的钱， 算一算，如果今晚去打劫，在不触动报警装置的情况下, 你最多可以得到多少钱 。
 *
 * 样例
 * 样例 1:
 *
 * 输入: [3, 8, 4]
 * 输出: 8
 * 解释: 仅仅打劫第二个房子.
 * 样例 2:
 *
 * 输入: [5, 2, 1, 3]
 * 输出: 8
 * 解释: 抢第一个和最后一个房子
 * 挑战
 * O(n) 时间复杂度 且 O(1) 存储。
 */
public class HouseRobber_392 {

    public long houseRobber(int[] A) {
        if (null == A || A.length < 1) {
            return 0;
        }

        if (A.length == 1) {
            return A[0];
        }

        long[] dp = new long[A.length];
        dp[0] = A[0];
        dp[1] = Math.max(A[0], A[1]);
        for (int i = 2; i < A.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + A[i]);
        }

        return dp[A.length - 1];
    }

    public long houseRobberWithArr(int[] A) {
        if(null == A || A.length < 1) {
            return 0;
        }

        if (A.length == 1) {
            return A[0];
        }

        long[] dp = new long[2];
        dp[0] = A[0];
        dp[1] = Math.max(A[0], A[1]);
        for (int i = 2; i < A.length; i++) {
            dp[i % 2] = Math.max(dp[(i - 2) % 2] + A[i], dp[(i - 1) % 2]);
        }

        return dp[(A.length - 1) % 2];
    }

}
