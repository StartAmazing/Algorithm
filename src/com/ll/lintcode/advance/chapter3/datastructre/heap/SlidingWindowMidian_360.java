package com.ll.lintcode.advance.chapter3.datastructre.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * 给定一个包含 n 个整数的数组，和一个大小为 k 的滑动窗口,从左到右在数组中滑动这个窗口，
 * 找到数组中每个窗口内的中位数。(如果数组个数是偶数，则在该窗口排序数字后，返回第 N/2 个数字。)
 * <p>
 * 样例
 * 样例 1:
 * <p>
 * 输入:
 * [1,2,7,8,5]
 * 3
 * 输出:
 * [2,7,7]
 * <p>
 * 解释:
 * 最初，窗口的数组是这样的：`[ | 1,2,7 | ,8,5]` , 返回中位数 `2`;
 * 接着，窗口继续向前滑动一次。`[1, | 2,7,8 | ,5]`, 返回中位数 `7`;
 * 接着，窗口继续向前滑动一次。`[1,2, | 7,8,5 | ]`, 返回中位数 `7`;
 * 样例 2:
 * <p>
 * 输入:
 * [1,2,3,4,5,6,7]
 * 4
 * 输出:
 * [2,3,4,5]
 * <p>
 * 解释:
 * 最初，窗口数组是这样的：`[ | 1,2,3,4, | 5,6,7]` , 返回中位数 `2`;
 * 接着，窗口向前滑动一次.`[1,| 2,3,4,5 | 6,7]`,返回中位数 `3`;
 * 接着，窗口向前滑动一次.`[1,2, | 3,4,5,6 | 7 ]`, 返回中位数 `4`;
 * 接着，窗口向前滑动一次`[1,2,3,| 4,5,6,7 ]`, 返回中位数 `5`;
 * 挑战
 * 时间复杂度为 O(nlog(n))
 */
public class SlidingWindowMidian_360 {

    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        TreeSet<Node> minheap = new TreeSet<Node>();
        TreeSet<Node> maxheap = new TreeSet<Node>();
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (k == 0)
            return result;

        int half = (k + 1) / 2;
        for (int i = 0; i < k - 1; i++) {
            add(minheap, maxheap, half, new Node(i, nums[i]));
        }
        for (int i = k - 1; i < n; i++) {
            add(minheap, maxheap, half, new Node(i, nums[i]));
            result.add(minheap.last().val);
            remove(minheap, maxheap, new Node(i - k + 1, nums[i - k + 1]));
        }
        return result;
    }

    void add(TreeSet<Node> minheap, TreeSet<Node> maxheap, int size, Node node) {
        if (minheap.size() < size) {
            minheap.add(node);
        } else {
            maxheap.add(node);
        }
        if (minheap.size() == size) {
            if (maxheap.size() > 0 && minheap.last().val > maxheap.first().val) {
                Node s = minheap.last();
                Node b = maxheap.first();
                minheap.remove(s);
                maxheap.remove(b);
                minheap.add(b);
                maxheap.add(s);
            }
        }
    }

    void remove(TreeSet<Node> minheap, TreeSet<Node> maxheap, Node node) {
        if (minheap.contains(node)) {
            minheap.remove(node);
        } else {
            maxheap.remove(node);
        }
    }
    public static void main(String[] args) {
        SlidingWindowMidian_360 dto = new SlidingWindowMidian_360();
        int[] data = new int[]{1, 2, 7, 7, 2};
        System.out.println(dto.medianSlidingWindow(data, 3));
    }
}

class Node implements Comparable<Node> {
    int id;
    int val;

    Node(int id, int val) {
        this.id = id;
        this.val = val;
    }

    public int compareTo(Node other) {
        Node a = (Node) other;
        if (this.val == a.val) {
            return this.id - a.id;
        }
        return this.val - a.val;
    }
}
