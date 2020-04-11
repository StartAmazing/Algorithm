package com.ll.lintcode.basic.dp;

/**
 * 假设你正在爬楼梯，需要n步你才能到达顶部。但每次你只能爬一步或者两步，你能有多少种不同的方法爬到楼顶部？
 *
 * 样例
 * Example 1:
 * 	Input:  n = 3
 * 	Output: 3
 *
 * 	Explanation:
 * 	1) 1, 1, 1
 * 	2) 1, 2
 * 	3) 2, 1
 * 	total 3.
 *
 *
 * Example 2:
 * 	Input:  n = 1
 * 	Output: 1
 *
 * 	Explanation:
 * 	only 1 way.
 */
public class ClimbingStairs_111 {

    public int climbStairs(int n) {
        if (n == 0 || n == 1 || n == 2){
            return n;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }


    public int climbStairsWithDp(int n) {
        if (n < 3){
            return n;
        }

        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        f[2] = 2;

        for (int i = 3; i < n + 1; i ++){
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }

    public int climbStairsWithDp2(int n) {
        if (n < 3){
            return n;
        }

        int[] f = new int[2];
        f[0] = 1;
        f[1] = 2;

        for (int i = 2; i < n; i ++){
            int tmp = f[0] + f[1];
            f[0] = f[1];
            f[1] = tmp;
        }

        return f[1];
    }
}
