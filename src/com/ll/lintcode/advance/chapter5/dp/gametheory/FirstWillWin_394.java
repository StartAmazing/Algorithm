package com.ll.lintcode.advance.chapter5.dp.gametheory;

/**
 * 描述
 * 有 n 个硬币排成一条线。两个参赛者轮流从右边依次拿走 1 或 2 个硬币，直到没有硬币为止。拿到最后一枚硬币的人获胜。
 * <p>
 * 请判定 先手玩家 必胜还是必败?
 * <p>
 * 若必胜, 返回 true, 否则返回 false.
 * <p>
 * 您在真实的面试中是否遇到过这个题？
 * 样例
 * 样例 1:
 * <p>
 * 输入: 1
 * 输出: true
 * 样例 2:
 * <p>
 * 输入: 4
 * 输出: true
 * 解释:
 * 先手玩家第一轮拿走一个硬币, 此时还剩三个.
 * 这时无论后手玩家拿一个还是两个, 下一次先手玩家都可以把剩下的硬币拿完.
 * 挑战
 * O(1) 时间复杂度且O(1) 存储。
 */
public class FirstWillWin_394 {

    // 如果是3的倍数，后手一定胜利
    public boolean firstWillWin_Math(int n) {
        return n % 3 != 0;
    }

    // 考虑先手的状态，不考虑后手的状态
    public boolean firstWillWin(int n) {
        if(n == 0) {
            return false;
        }
        if (n <= 2) {
            return true;
        }
        if (n == 3) {
            return false;
        }

        boolean[] dp = new boolean[n + 1];
        dp[0] = false;
        dp[1] = true;
        dp[2] = true;
        dp[3] = false;
        for(int i = 4; i < dp.length; i++) {
            dp[i] = (dp[i - 2] && dp[i - 3]) || (dp[i - 3] && dp[i - 4]);
        }
        return dp[n];
    }

    public boolean firstWillWin_Memorization(int n) {
        if (n <= 0) {
            return false;
        }

        int[] dp = new int[n + 1];
        return memorySearch(n, dp);
    }


    private boolean memorySearch(int n, int[] dp) {  // 0 is empty， 1 is false, 2 is true
        if(dp[n] != 0) {
            return dp[n] == 1;
        }

        if (n <= 0) {
            dp[n] = 1;
        } else if (n == 1 || n ==2) {
            dp[n] = 2;
        } else if(n == 3) {
            dp[n] = 1;
        } else {
            dp[n] = (memorySearch(n - 3, dp) && memorySearch(n - 2, dp))
                    || (memorySearch(n - 3, dp) && memorySearch(n - 4, dp))
                    ? 2 : 1;
        }


        return dp[n] == 2;
    }


}
