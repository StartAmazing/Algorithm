package com.ll.lintcode.advance.chapter1.kth.matrix;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定两个排好序的数组 A, B，定义集合 sum = a + b ，其中a来自A数组，b来自B数组，求 sum 中第k小的元素
 *
 * 样例
 * 样例1
 *
 * 输入:
 * a = [1, 7, 11]
 * b = [2, 4, 6]
 * k = 3
 * 输出: 7
 * 说明: 满足条件的所有的和有[3, 5, 7, 9, 11, 13, 13, 15, 17]，其中第三个是7.
 * 样例2
 *
 * 输入:
 * a = [1, 7, 11]
 * b = [2, 4, 6]
 * k = 4
 * 输出: 9
 * 说明: 满足条件的所有的和有[3, 5, 7, 9, 11, 13, 13, 15, 17]，其中第四个是9.
 * 样例3
 *
 * 输入:
 * a = [1, 7, 11]
 * b = [2, 4, 6]
 * k = 8
 * 输出: 15
 * 说明: 满足条件的所有的和有[3, 5, 7, 9, 11, 13, 13, 15, 17]，其中第八个是15.
 * 挑战
 * 挑战一下更小的时间复杂度做法：
 *
 * O(k log_{min(n,m,k)})O(klog
 * min(n,m,k)
 * ​
 *  ), nn 是A 数组的大小，mm是B 数组的大小
 * O((m+n)log_{maxValue})O((m+n)log
 * maxValue
 * ​
 *  ),maxValuemaxValue是 A 数组和 B 数组中的最大值
 */
public class KthSmallestSumInTwoSortedArrays_x {

    static class Node implements Comparator<Node> {
        public int value;
        public int aIdx;
        public int bIdx;
        //value权值大小 aIdx在A的哪个位置，bIdx在B的哪个位置
        public Node(int value, int arrayIdx, int idx) {
            this.value = value;
            this.aIdx = arrayIdx;
            this.bIdx = idx;
        }
        public int compare(Node n1, Node n2) {
            if(n1.value < n2.value) {
                return 1;
            } else {
                return 0;
            }
        }
    }
    static Comparator<Node> cNode = new Comparator<Node>() {
        public int compare(Node o1, Node o2) {
            return o1.value - o2.value;
        }
    };
    /**
     * @param A: an integer arrays sorted in ascending order
     * @param B: an integer arrays sorted in ascending order
     * @param k: An integer
     * @return: An integer
     */
    public int kthSmallestSum(int[] A, int[] B, int k) {
        // write your code here
        // 初始化 优先队列 ，我们优先队列的一个元素包括三个值 ：数字大小，数字在AB数组的位置
        PriorityQueue<Node> q = new PriorityQueue<Node>(cNode);

        int n = A.length;
        int m = B.length;
        for(int i = 0; i < m; i++) {
            q.add(new Node(A[0] + B[i], 0, i));
        }
        while(k > 1) {
            k -= 1;
            // 取出队列中最小值
            Node point = q.poll();

            // a+b权值 ，a在A数组中的编号，b在B数组中的位置
            int aIdx = point.aIdx;
            int bIdx = point.bIdx;
            //压入aIdx+1,bIdx
            if(aIdx != n - 1) {
                q.add(new Node(A[aIdx + 1] + B[bIdx], aIdx + 1, bIdx));
            }
        }
        return q.poll().value;
    }
}
