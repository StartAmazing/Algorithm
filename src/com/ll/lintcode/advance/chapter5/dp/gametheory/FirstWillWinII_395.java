package com.ll.lintcode.advance.chapter5.dp.gametheory;

/**
 * 有 n 个不同价值的硬币排成一条线。两个参赛者轮流从 左边 依次拿走 1 或 2 个硬币，
 * 直到没有硬币为止。计算两个人分别拿到的硬币总价值，价值高的人获胜。
 * <p>
 * 请判定 先手玩家 必胜还是必败?
 * <p>
 * 若必胜, 返回 true, 否则返回 false.
 * <p>
 * 样例
 * 样例 1:
 * <p>
 * 输入: [1, 2, 2]
 * 输出: true
 * 解释: 先手玩家直接拿走两颗硬币即可.
 * 样例 2:
 * <p>
 * 输入: [1, 2, 4]
 * 输出: false
 * 解释: 无论先手拿一个还是两个, 后手可以拿完, 然后总价值更高.
 */
public class FirstWillWinII_395 {

    // 判断先手取得的价值是否大于总和的一半
    public boolean firstWillWin(int[] values) {
        int size = values.length;
        if (size <= 2) {
            return true;
        }

        int sum = 0;
        for (Integer value : values) {
            sum += value;
        }

        int[] dp = new int[values.length + 1];
        dp[0] = 0;
        dp[1] = values[0];
        dp[2] = values[1] + values[0];
        dp[3] = values[1] + values[0];
        for (int i = 4; i <= values.length; i++) {
            dp[i] = Math.max(values[values.length - i] + Math.min(dp[i - 2], dp[i - 3]),
                    values[values.length - i] + values[values.length - i + 1] + Math.min(dp[i - 3], dp[i - 4]));
        }


        return dp[values.length] * 2 > sum;
    }

    public boolean firstWillWin_memory(int[] values) {
        int[] dp = new int[values.length + 1];
        boolean[] flag = new boolean[values.length + 1];
        int sum = 0;
        for (Integer ele : values) {
            sum += ele;
        }

        return sum < 2 * memorySearch(values.length, dp, flag, values);
    }

    private int memorySearch(int n, int[] dp, boolean[] flag, int[] values) {
        if (flag[n]) {
            return dp[n];
        }
        flag[n] = true;
        if (n == 0) {
            dp[n] = 0;
        } else if (n == 1) {
            dp[n] = values[values.length - 1];
        } else if (n == 2) {
            dp[n] = values[values.length - 1] + values[values.length - 2];
        } else if (n == 3) {
            dp[n] = values[values.length - 2] + values[values.length - 3];
        } else {
            dp[n] = Math.max(
                    Math.min(memorySearch(n - 2, dp, flag, values), memorySearch(n - 3, dp, flag, values)) + values[values.length - n],
                    Math.min(memorySearch(n - 3, dp, flag, values), memorySearch(n - 4, dp, flag, values)) + values[values.length - n] + values[values.length - n + 1]
            );
            dp[n] = Math.max(
                    Math.min(memorySearch(n - 2, dp, flag, values), memorySearch(n - 3, dp, flag, values)) + values[values.length - n],
                    Math.min(memorySearch(n - 3, dp, flag, values), memorySearch(n - 4, dp, flag, values)) + values[values.length - n] + values[values.length - n + 1]
            );
        }


        return dp[n];
    }

    public static void main(String[] args) {
        FirstWillWinII_395 dto = new FirstWillWinII_395();
        int[] data = new int[]{1, 2, 4, 8};
        System.out.println(dto.firstWillWin(data));
    }
}
