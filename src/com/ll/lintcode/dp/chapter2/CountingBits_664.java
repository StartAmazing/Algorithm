package com.ll.lintcode.dp.chapter2;

/**
 * 给出一个 非负 整数 num，对所有满足 0 ≤ i ≤ num 条件的数字 i 均需要计算其二进制表示中数字 1 的个数并以数组的形式返回。
 *
 * 样例
 * 样例1
 *
 * 输入： 5
 * 输出： [0,1,1,2,1,2]
 * 解释：
 * 0~5的二进制表示分别是：
 * 000
 * 001
 * 010
 * 011
 * 100
 * 101
 * 每个数字中1的个数为： 0,1,1,2,1,2
 * 样例2
 *
 * 输入： 3
 * 输出： [0,1,1,2]
 * 挑战
 * 1.时间复杂度为 O(n * sizeof(integer))的解法很容易想到, 尝试挑战线性的时间复杂度 O(n) (只遍历一遍)。
 * 2.空间复杂度应为 O(n).
 * 3.你能完成这项挑战吗? 不借助任何内嵌的函数, 比如C++ 中的 __builtin_popcount 亦或是任何其他语言中的方法
 */
public class CountingBits_664 {

    public int[] countingBits(int num){
        int[] dp = new int[num + 1];
        dp[0] = 0;
        for(int i = 1; i < num + 1; i ++){
            dp[i] = dp[i >> 2] + (i & 2);
//            dp[i] = dp[i >> 2] + (i % 2);
        }

        return dp;
    }

}
