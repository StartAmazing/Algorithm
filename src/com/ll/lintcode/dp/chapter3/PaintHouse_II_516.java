package com.ll.lintcode.dp.chapter3;

import org.omg.CORBA.INTERNAL;

/**
 * 这里有n个房子在一列直线上，现在我们需要给房屋染色，共有k种颜色。每个房屋染不同的颜色费用也不同，你需要设计一种染色方案使得相邻的房屋颜色不同，并且费用最小。
 *
 * 费用通过一个nxk 的矩阵给出，比如cost[0][0]表示房屋0染颜色0的费用，cost[1][2]表示房屋1染颜色2的费用。
 *
 * 样例
 * 样例1
 *
 * 输入:
 * costs = [[14,2,11],[11,14,5],[14,3,10]]
 * 输出: 10
 * 说明:
 * 三个屋子分别使用第1,2,1种颜色，总花费是10。
 * 样例2
 *
 * 输入:
 * costs = [[5]]
 * 输出: 5
 * 说明：
 * 只有一种颜色，一个房子，花费为5
 * 挑战
 * 用O(nk)的时间复杂度解决
 *
 * 注意事项
 * 所有费用都是正整数
 */
public class PaintHouse_II_516 {

    public int minCostII(int[][] costs) {

        if (null == costs || costs.length < 1){
            return 0;
        }

        int[][] dp = new int[costs.length][costs[0].length];
        for (int i = 0; i < dp.length; i ++){
            for (int j = 0; j < dp[i].length; j ++){
                if (i == 0) {
                    dp[i][j] = costs[i][j];
                }else{
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = 0; k < dp[i].length; k++) {
                        if (k != j) {
                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + costs[i][j]);
                        }
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (Integer value : dp[dp.length - 1]){
            ans = Math.min(ans, value);
        }

        return ans;
    }

    public int minCostII2(int[][] costs) {

        if (null == costs || costs.length < 1){
            return 0;
        }

        int[][] dp = new int[costs.length][costs[0].length];
        //minimum value, second minimum value
        int min1, min2;
        //minimum index, second minimum index
        int id1 = 0, id2 = 0;

        for (int i = 0; i < dp[0].length; i ++){
            dp[0][i] = costs[0][i];
        }

        for (int i = 1; i < dp.length; i ++){
                min1 = min2 = Integer.MAX_VALUE;
                for (int j = 0; j < dp[i].length; j++) {
                    if (dp[i - 1][j] < min1) {
                        min2 = min1;
                        min1 = dp[i - 1][j];
                        id2 = id1;
                        id1 = j;
                    }else{
                        if (dp[i - 1][j] < min2){
                            min2 = dp[i - 1][j];
                            id2 = j;
                        }
                    }
                }

            for (int j = 0; j < dp[i].length; j ++){
                dp[i][j] = costs[i][j];
                if (j != id1){
                    dp[i][j] += min1;
                }else{
                    dp[i][j] += min2;
                }

            }
        }

        int ans = Integer.MAX_VALUE;
        for (Integer value : dp[dp.length - 1]){
            ans = Math.min(ans, value);
        }

        return ans;
    }

}
