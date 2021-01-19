package com.ll.lintcode.dp.chapter2;

/**
 * 序列型动态规划
 *
 * 这里有n个房子在一列直线上，现在我们需要给房屋染色，分别有红色蓝色和绿色。
 * 每个房屋染不同的颜色费用也不同，你需要设计一种染色方案使得相邻的房屋颜色不同，
 * 并且费用最小，返回最小的费用。
 * <p>
 * 费用通过一个nx3 的矩阵给出，比如cost[0][0]表示房屋0染红色的费用，cost[1][2]表示房屋1染绿色的费用。
 * <p>
 * 样例
 * 样例 1:
 * <p>
 * 输入: [[14,2,11],[11,14,5],[14,3,10]]
 * 输出: 10
 * 解释: 第一个屋子染蓝色，第二个染绿色，第三个染蓝色，最小花费：2 + 5 + 3 = 10.
 * 样例 2:
 * <p>
 * 输入: [[1,2,3],[1,4,6]]
 * 输出: 3
 * 注意事项
 * 所有费用都是正整数
 */
public class PaintHouse_515 {

    public int paintHouse(int[][] costs) {
        if (costs == null || costs.length < 1){
            return 0;
        }
        int[][] dp = new int[costs.length][costs[0].length];
        System.arraycopy(costs[0], 0, dp[0], 0, dp[0].length);

        for (int i = 1; i < costs.length; i++) {
            for (int j = 0; j < costs[i].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < dp[i - 1].length; k++) {
                    if (k != j) {
                        dp[i][j] = Math.min(dp[i][j], costs[i][j] + dp[i - 1][k]);
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < dp[dp.length - 1].length; i++) {
            ans = Math.min(ans, dp[dp.length - 1][i]);
        }

        return ans;
    }

    public int minCost(int[][] costs) {
        if(costs == null || costs.length < 1){
            return 0;
        }

        int col = 3;
        int row = costs.length + 1;
        int[][] dp = new int[row][col];
        for (int i = 1; i < row; i++) {
            for(int j = 0; j < col; j++) {
                dp[i][j] = costs[i - 1][j];
                int min = Integer.MAX_VALUE;
                for(int k = 0; k < col; k++) {
                    if(k != j) {
                        min = Math.min(dp[i-1][k], min);
                    }
                }

                dp[i][j] += min;
            }
        }

        int res = dp[row - 1][0];
        for(int i = 1; i < col; i++) {
            res = Math.min(res, dp[row - 1][i]);
        }

        return res;
    }

    public static void main(String[] args) {
        PaintHouse_515 dto = new PaintHouse_515();
        int[][] cost = new int[][]{ {14, 2, 11},
                                    {11, 14, 5},
                                    {14, 3, 10}};
        int i = dto.minCost(cost);
        System.out.println(i);
    }

}
