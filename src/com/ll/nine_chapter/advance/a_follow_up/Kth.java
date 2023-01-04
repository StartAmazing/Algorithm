package com.ll.nine_chapter.advance.a_follow_up;

import com.ll.utils.TimeOut;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Kth {

    private class Pair implements Comparable<Pair> {
        public int x;
        public int y;
        public int val;

        public Pair(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Pair o) {
            return this.val - o.val;
        }
    }

    /**
     * @link https://www.lintcode.com/problem/1272
     * @param matrix: List[List[int]]
     * @param k: a integer
     * @return: return a integer
     */
    public int kthSmallest(int[][] matrix, int k) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        Queue<Pair> pq = new PriorityQueue<>();
        visited[0][0] = true;
        pq.add(new Pair(0, 0, matrix[0][0]));
        while(!pq.isEmpty() && k > 1) {
            k--;
            Pair cur = pq.poll();
            if(cur.x + 1 < matrix.length && !visited[cur.x + 1][cur.y]) {
                pq.offer(new Pair(cur.x + 1, cur.y, matrix[cur.x + 1][cur.y]));
                visited[cur.x + 1][cur.y] = true;
            }
            if(cur.y + 1 < matrix[0].length && !visited[cur.x][cur.y + 1]) {
                pq.offer(new Pair(cur.x, cur.y + 1, matrix[cur.x][cur.y + 1]));
                visited[cur.x][cur.y + 1] = true;
            }
        }

        if (pq.isEmpty()) {
            return -1;
        }
        return pq.poll().val;
    }

    private class Pair2 implements Comparable<Pair2> {
        public int x;
        public int y;
        public long val;

        public Pair2(int x, int y, long val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Pair2 o) {
            if(this.val == o.val) {
                return 0;
            }
            return this.val - o.val > 0 ? 1 : -1;
        }
    }

    /**
     * @link https://leetcode.cn/problems/kth-smallest-product-of-two-sorted-arrays/submissions/
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    @TimeOut
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long[][] data = new long[nums1.length][nums2.length];
        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                data[i][j] = (long) nums1[i] * (long) nums2[j];
            }

            Arrays.sort(data[i]);
        }

        Queue<Pair2> pq = new PriorityQueue<>();
        for(int i = 0; i < data.length; i ++) {
            pq.offer(new Pair2(i, 0, data[i][0]));
        }

        while(!pq.isEmpty() && k > 1) {
            k--;
            Pair2 cur = pq.poll();
            if(cur.y + 1 < data[cur.x].length) {
                pq.offer(new Pair2(cur.x, cur.y + 1, data[cur.x][cur.y + 1]));
            }
        }

        if(pq.isEmpty()) {
            return -1;
        }

        return pq.poll().val;
    }

    /**
     * @link https://leetcode.cn/problems/kth-smallest-sum-of-two-sorted-arrays/  -- link is valid, lintcode need vip
     * @link https://www.lintcode.com/problem/465/
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public long kthSmallestSum(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] pos1 = new int[]{0, 1};
        int[] pos2 = new int[]{1, 0};
        int len1 = nums1.length;
        int len2 = nums2.length;
        boolean[][] visited = new boolean[nums1.length][nums2.length];
        visited[0][0] = true;
        pq.add(new Pair(0, 0, nums1[0] + nums2[0]));
        while(k > 1 && !pq.isEmpty()) {
            k--;
            Pair cur = pq.poll();
            for(int i = 0; i < 2; i++) {
                if(cur.x + pos1[i] < len1 && cur.y + pos2[i] < len2 && !visited[cur.x + pos1[i]][cur.y + pos2[i]]) {
                    pq.add(new Pair(cur.x + pos1[i], cur.y + pos2[i], nums1[cur.x + pos1[i]] + nums2[cur.y + pos2[i]]));
                    visited[cur.x + pos1[i]][cur.y + pos2[i]] = true;
                }
            }
        }

        if (pq.isEmpty()) {
            return -1;
        }

        return pq.poll().val;
    }


    public static void main(String[] args) {
        Kth dto = new Kth();
        int[] xdata = new int[]{2, 5};
        int[] ydata = new int[]{3, 4};

        System.out.println(dto.kthSmallestProduct(xdata, ydata, 2));
    }
}
