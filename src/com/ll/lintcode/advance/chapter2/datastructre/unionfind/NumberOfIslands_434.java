package com.ll.lintcode.advance.chapter2.datastructre.unionfind;

import com.ll.muke.queue.Array;

import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 描述
 * 给定 n, m, 分别代表一个二维矩阵的行数和列数, 并给定一个大小为 k 的二元数组A. 初始二维矩阵全0.
 * 二元数组A内的k个元素代表k次操作, 设第i个元素为 (A[i].x, A[i].y),
 * 表示把二维矩阵中下标为A[i].x行A[i].y列的元素由海洋变为岛屿. 问在每次操作之后, 二维矩阵中岛屿的数量.
 * 你需要返回一个大小为k的数组.
 *
 * 设定0表示海洋, 1代表岛屿, 并且上下左右相邻的1为同一个岛屿.
 *
 * 您在真实的面试中是否遇到过这个题？
 * 样例
 * 样例 1:
 *
 * 输入: n = 4, m = 5, A = [[1,1],[0,1],[3,3],[3,4]]
 * 输出: [1,1,2,2]
 * 解释:
 * 0.  00000
 *     00000
 *     00000
 *     00000
 * 1.  00000
 *     01000
 *     00000
 *     00000
 * 2.  01000
 *     01000
 *     00000
 *     00000
 * 3.  01000
 *     01000
 *     00000
 *     00010
 * 4.  01000
 *     01000
 *     00000
 *     00011
 * 样例 2:
 *
 * 输入: n = 3, m = 3, A = [[0,0],[0,1],[2,2],[2,1]]
 * 输出: [1,1,2,2]
 */
class Point {
    public int x;
    public int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}

/**
 * O(m * n + k)
 */
public class NumberOfIslands_434 {

    class UnionFind{
        public int[] father = null;

        public UnionFind(int x) {
            father = new int[x + 1];
            for (int i = 1; i < father.length; i++) {
                father[i] = i;
            }
        }

        public void connect(int a, int b) {
            int root_a = findFather(a);
            int root_b = findFather(b);
            if (root_a != root_b) {
                father[root_a] = root_b;
            }
        }

        public int findFather(int a) {
            if (a == father[a]) {
                return a;
            }

            return father[a] = findFather(father[a]);
        }
    }


    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        if (null == operators || operators.length < 1) {
            return null;
        }
        List<Integer> ans = new ArrayList<>();
        int len = m * n;

        UnionFind un = new UnionFind(len);
        int[][] isLand = new int[n][m];
        int count = 0;

        int[] posX = new int[]{0, 0,1,-1};
        int[] posY = new int[]{-1, 1, 0, 0};

        for (int i = 0; i < operators.length; i++) {
            int curX = operators[i].x;
            int curY = operators[i].y;
            if (isLand[curX][curY] == 0) {
                count++;
                isLand[curX][curY] = 1;
                int curId = pos2Id(m, operators[i]);
                for (int j = 0; j < 4; j ++) {
                    int nextX = curX + posX[j];
                    int nextY = curY + posY[j];
                    Point nextPoint = new Point(nextX, nextY);
                    int nextId = pos2Id(m, nextPoint);
                    if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && isLand[nextX][nextY] == 1 ) {
                        int curFather = un.findFather(curId);
                        int nextFather = un.findFather(nextId);
                        if (curFather != nextFather) {
                            count --;
                            un.connect(curFather, nextFather);
                        }
                    }
                }
            }
            ans.add(count);
        }
        return ans;
    }

    private int pos2Id(int row, Point point) {
        return point.x * row + point.y;
    }

    public static void main(String[] args) {
        NumberOfIslands_434 dto = new NumberOfIslands_434();
        int n = 4, m = 5;
        Point[] op = new Point[]{new Point(1,1), new Point(0, 1), new Point(3,3), new Point(3, 4)};

        List<Integer> integers = dto.numIslands2(n, m, op);
        System.out.println(integers);

    }

}
