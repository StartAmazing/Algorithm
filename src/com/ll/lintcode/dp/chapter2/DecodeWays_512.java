package com.ll.lintcode.dp.chapter2;

/**
 * 划分型动态规划
 *
 * 有一个消息包含A-Z通过以下规则编码
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 现在给你一个加密过后的消息，问有几种解码的方式
 *
 * 样例
 * 样例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以被解码为 AB (1 2) 或 L (12).
 * 样例 2:
 *
 * 输入: "10"
 * 输出: 1
 * 注意事项
 * we can't decode an empty string. So you should return 0 if the message is empty.
 */
public class DecodeWays_512 {

    /**
     *
     * 设数字串长度为N
     * 要求数字串前N个字的解密方式数量
     * 需要知道数字串前N - 1和 N - 2个字符的解密方式数
     * 子问题
     * 状态：设数字串S前i个数字解密成字母串有f[i]种方式
     *
     * f[i] = f[i - 1] | S[i - 1]对应一个字母 + f[i - 2] | S[i - 1]S[i - 2]对应一个字母
     *
     * 设数字串S前i个数字解密成字母串有f[i]种方式
     * 初始条件： f[0] = 1，即空串有1种解决方式解密 -解密成空串
     * 边界情况： 如果i = 1，只看最后一个数字
     *
     * 计算顺序是从f[0], f[1], ..., f[N]
     */
    public int decodeWays(String ss){
        char[] chars = ss.toCharArray();
        int n = chars.length;
        if(n == 0){
            return 1;
        }

        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i ++){
            f[i] = 0;
            if (chars[i - 1] >= '1' && chars[i - 1] <= '9'){
                f[i] += f[i - 1];
            }

            //check whether i > 1
            if (i > 1){
                //chars[i - 2][i - 1]
                int j = (10 * chars[i - 2] - '0') + (chars[i - 1] - '0');
                if (j >= 10 && j <= 26){
                    f[i] += f[i - 2];
                }
            }
        }

        return f[n];
    }
}
