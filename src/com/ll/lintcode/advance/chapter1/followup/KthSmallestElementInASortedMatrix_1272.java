package com.ll.lintcode.advance.chapter1.followup;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个 n x n 矩阵，每一行和每一列都按照升序排序，找出矩阵中的第 k 小元素。
 *
 * 注意是需要找将所有元素有序排列的第 k 小元素，而不是第 k 个互不相同的元素。
 *
 * 样例
 * 样例1
 *
 * 输入：
 * [[ 1,  5,  9],[10, 11, 13],[12, 13, 15]]
 * 8
 * 输出： 13
 * 样例2
 *
 * 输入：
 * [[-5]]
 * 1
 * 输出： -5
 * 挑战
 * 如果 k << n^2，最好的算法是什么？
 * 如果 k ~ n^2 呢？
 *
 * 注意事项
 * 你可以认为 k 始终是合法的，也就是说，1 ≤ k ≤ n^2。
 */
public class KthSmallestElementInASortedMatrix_1272 {

    public class Pair{
        public int x;
        public int y;
        public int val;
        public Pair(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public class PairComparator implements Comparator<Pair>{
        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.val - o2.val;
        }
    }


    public int kthSmallest(int[][] matrix, int k){
        if (matrix == null || matrix.length * matrix[0].length < k){
            return -1;
        }

        //方向数组,从上往下看
        int[] dx = new int[]{0, 1};
        int[] dy = new int[]{1, 0};

        int rowNum = matrix.length;
        int colNum = matrix[0].length;

        boolean[][] isTraversal = new boolean[rowNum][colNum];

        PriorityQueue<Pair> hMin = new PriorityQueue<>(new PairComparator());

        hMin.add(new Pair(0, 0, matrix[0][0]));
        isTraversal[0][0] = true;

        for (int i = 0; i < k - 1; i ++){
            Pair cur = hMin.poll();
            for (int j = 0; j < 2; j ++){
                int next_x = cur.x + dx[j];
                int next_y = cur.y + dy[j];
                Pair next = new Pair(next_x, next_y, 0);
                if (next_x < rowNum && next_y < colNum && !isTraversal[next_x][next_y]){
                    isTraversal[next_x][next_y] = true;
                    next.val = matrix[next_x][next_y];
                    hMin.add(next);
                }
            }
        }
        return hMin.peek().val;
    }
}
