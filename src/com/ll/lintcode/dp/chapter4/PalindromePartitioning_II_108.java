package com.ll.lintcode.dp.chapter4;

/**
 * 给定字符串 s, 需要将它分割成一些子串, 使得每个子串都是回文串.
 *
 * 最少需要分割几次?
 *
 * 样例
 * 样例 1:
 *
 * 输入: "a"
 * 输出: 0
 * 解释: "a" 本身就是回文串, 无需分割
 * 样例 2:
 *
 * 输入: "aab"
 * 输出: 1
 * 解释: 将 "aab" 分割一次, 得到 "aa" 和 "b", 它们都是回文串
 */
public class PalindromePartitioning_II_108 {

    public int minCut(String s){
        if (null == s || s.length() < 1){
            return 0;
        }
        int len = s.length();

        int[] dp = new int[len + 1];
        boolean[][] isPalin = isPalin(s);
        dp[0] = 0;
        for (int i = 1; i < len + 1; i ++){
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j ++){
                if (isPalin[j][i - 1]){
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
        }


        return dp[len] - 1;
    }

    private boolean[][] isPalin(String s){
        int len = s.length();
        boolean[][] f = new boolean[len][len];
        int i, j, c;
        for (c = 0; c < len; c ++){
            i = j = c;
            while (j >= 0 && i < len && s.charAt(i) == s.charAt(j)){
                f[j][i] = true;
                i ++;
                j --;
            }
        }

        for (c = 0; c < len - 1; c ++){
            j = c;
            i = c + 1;
            while (j >= 0 && i < len && s.charAt(i) == s.charAt(j)){
                f[j][i] = true;
                i ++;
                j --;
            }
        }

        return f;
    }

    public static void main(String[] args) {
        PalindromePartitioning_II_108 dto = new PalindromePartitioning_II_108();
        String s = "ab";
        dto.minCut(s);
    }
}
