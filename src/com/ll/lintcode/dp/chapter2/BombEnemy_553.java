package com.ll.lintcode.dp.chapter2;

/**
 * 给定一个二维矩阵, 每一个格子可能是一堵墙 W,或者 一个敌人 E 或者空 0 (数字 '0'), 返回你可以用一个炸弹杀死的最大敌人数. 炸弹会杀死所有在同一行和同一列没有墙阻隔的敌人。 由于墙比较坚固，所以墙不会被摧毁.
 * <p>
 * 样例
 * 样例1
 * <p>
 * 输入:
 * grid =[
 * "0E00",
 * "E0WE",
 * "0E00"
 * ]
 * 输出: 3
 * 解释:
 * 把炸弹放在 (1,1) 能杀3个敌人
 * 样例2
 * <p>
 * 输入:
 * grid =[
 * "0E00",
 * "EEWE",
 * "0E00"
 * ]
 * 输出: 2
 * 解释:
 * P把炸弹放在 (0,0) 或 (0,3) 或 (2,0) 或 (2,3) 能杀2个敌人
 * 注意事项
 * 你只能在空的地方放置炸弹.
 */
public class BombEnemy_553 {

    public int maxKilledEnemies(char[][] grid) {
        if (null == grid || grid.length < 1) {
            return 0;
        }

        int[][] updp = new int[grid.length][grid[0].length];
        int[][] downdp = new int[grid.length][grid[0].length];
        int[][] leftdp = new int[grid.length][grid[0].length];
        int[][] rightdp = new int[grid.length][grid[0].length];

        int i, j, rows = grid.length, cols = grid[0].length;

        //up
        for (i = 0; i < rows; i++) {
            for (j = 0; j < cols; j++) {
                if (grid[i][j] == 'W') {
                    updp[i][j] = 0;
                    continue;
                }
                updp[i][j] = (grid[i][j] == 'E' ? 1 : 0);

                if (i > 0) {
                    updp[i][j] += updp[i - 1][j];
                }
            }
        }

        //down
        for (i = rows - 1; i >= 0; i--) {
            for (j = 0; j < cols; j++) {
                if (grid[i][j] == 'W') {
                    downdp[i][j] = 0;
                    continue;
                }

                downdp[i][j] = (grid[i][j] == 'E' ? 1 : 0);

                if (i < rows - 1) {
                    downdp[i][j] += downdp[i + 1][j];
                }
            }
        }

        //left
        for (j = 0; j < cols; j++) {
            for (i = 0; i < rows; i++) {

                if (grid[i][j] == 'W') {
                    leftdp[i][j] = 0;
                    continue;
                }

                leftdp[i][j] = (grid[i][j] == 'E' ? 1 : 0);

                if (j > 0) {
                    leftdp[i][j] += leftdp[i][j - 1];
                }
            }
        }

        //right
        for (j = cols - 1; j >= 0; j--) {
            for (i = 0; i < rows; i++) {
                if (grid[i][j] == 'W') {
                    rightdp[i][j] = 0;
                    continue;
                }
                rightdp[i][j] = (grid[i][j] == 'E' ? 1 : 0);

                if (j < cols - 1) {
                    rightdp[i][j] += rightdp[i][j + 1];
                }
            }
        }

        int ans = 0;
        for (i = 0; i < rows; i++) {
            for (j = 0; j < cols; j++) {
                if (grid[i][j] != 'E' && grid[i][j] != 'W') {
                    int tmp = updp[i][j] + downdp[i][j] + leftdp[i][j] + rightdp[i][j];
                    ans = Math.max(ans, tmp);
                }
            }
        }

        return ans;
    }

}


