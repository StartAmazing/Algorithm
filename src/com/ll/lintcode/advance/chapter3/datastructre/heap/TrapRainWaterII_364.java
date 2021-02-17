package com.ll.lintcode.advance.chapter3.datastructre.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 给出 n * m 个非负整数，代表一张X轴上每个区域为 1 * 1 的 2d 海拔图, 计算这个海拔图最多能接住多少（面积）雨水。
 * <p>
 * <p>
 * <p>
 * 样例
 * 样例 1:
 * <p>
 * 例如，给定一个 5*4 的矩阵：
 * 输入:
 * [[12,13,0,12],[13,4,13,12],[13,8,10,12],[12,13,12,12],[13,13,13,13]]
 * 输出:
 * 14
 * 样例 2:
 * <p>
 * 输入:
 * [[2,2,2,2],[2,2,3,4],[3,3,3,1],[2,3,4,5]]
 * 输出:
 * 0
 * <p>
 * 提示： 用堆维护最外层最小的灌水高度
 * O(n + m + m*n*log(n + m))
 */
public class TrapRainWaterII_364 {

    class Pair {
        public int x;
        public int y;
        public int val;

        public Pair() {

        }

        public Pair(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

    }

    public int trapRainWater(int[][] heights) {
        if (heights == null || heights.length < 3) {
            return 0;
        }

        // 结果
        int ans = 0;
        boolean[][] isVisited = new boolean[heights.length][heights[0].length];

        // 方向数组
        int[] posX = new int[]{1, -1, 0, 0};
        int[] posY = new int[]{0, 0, 1, -1};

        Queue<Pair> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.val > o2.val) {
                return 1;
            } else if (o1.val == o2.val) {
                return 0;
            } else {
                return -1;
            }
        });


        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (i == 0 || j == 0 || i == heights.length - 1 || j == heights[0].length - 1) {
                    pq.offer(new Pair(i, j, heights[i][j]));
                    isVisited[i][j] = true;
                }
            }
        }

        while (!pq.isEmpty()) {
            Pair curPair = pq.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = curPair.x + posX[i];
                int nextY = curPair.y + posY[i];
                if (nextX < 0 || nextX >= heights.length || nextY < 0 || nextY >= heights[0].length || isVisited[nextX][nextY]) {
                    continue;
                }
                isVisited[nextX][nextY] = true;
//                ans += Math.max(0, curPair.val - heights[nextX][nextY]);
                pq.offer(new Pair(nextX, nextY, Math.max(heights[nextX][nextY], curPair.val)));


                if (heights[nextX][nextY] < curPair.val) {
                    ans += (curPair.val - heights[nextX][nextY]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TrapRainWaterII_364 dto = new TrapRainWaterII_364();
        int[][] data = new int[][]{{12,  13, 0, 12},{13, 4, 13, 12},{13, 11, 12, 12}, {12, 13, 12, 12}, {13, 13, 13, 13}};
        System.out.println(dto.trapRainWater(data));
    }
}
