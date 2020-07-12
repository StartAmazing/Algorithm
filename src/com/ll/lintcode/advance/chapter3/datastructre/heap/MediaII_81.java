package com.ll.lintcode.advance.chapter3.datastructre.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 数字是不断进入数组的，在每次添加一个新的数进入数组的同时返回当前新数组的中位数。
 *
 * 您在真实的面试中是否遇到过这个题？
 * 说明
 * 中位数的定义：
 *
 * 这里的中位数不等同于数学定义里的中位数。
 * 中位数是排序后数组的中间值，如果有数组中有n个数，则中位数为A[(n-1)/2]。
 * 比如：数组A=[1,2,3]的中位数是2，数组A=[1,19]的中位数是1。
 * 样例
 * 样例1
 *
 * 输入: [1,2,3,4,5]
 * 输出: [1,1,2,2,3]
 * 样例说明：
 * [1] 和 [1,2] 的中位数是 1.
 * [1,2,3] 和 [1,2,3,4] 的中位数是 2.
 * [1,2,3,4,5] 的中位数是 3.
 * 样例2
 *
 * 输入: [4,5,1,3,2,6,0]
 * 输出: [4,4,4,3,3,3,3]
 * 样例说明：
 * [4], [4,5] 和 [4,5,1] 的中位数是 4.
 * [4,5,1,3], [4,5,1,3,2], [4,5,1,3,2,6] 和 [4,5,1,3,2,6,0] 的中位数是 3.
 * 挑战
 * 时间复杂度为O(nlogn)
 *
 * 提示: 存小值的大根堆和存大值的小根堆
 *
 */
public class MediaII_81 {
    PriorityQueue<Integer> maxHeap, minHeap;
    private int numOfElement = 0;

    public int[] medianII(int[] nums) {
        Comparator<Integer> revCmp = (o1, o2) -> o2 - o1;
        int cn = nums.length;
        maxHeap = new PriorityQueue<>(revCmp);
        minHeap = new PriorityQueue<>();
        int[] ans = new int[cn];
        for (int i = 0; i < ans.length; i++) {
            addNumber(nums[i]);
            ans[i] = getMedia();
        }

        return ans;
    }

    private void addNumber(int number) {
        maxHeap.add(number);
        if (numOfElement % 2 == 0) {
            if (minHeap.isEmpty()) {
                numOfElement++;
                return;
            } else if(maxHeap.peek() > minHeap.peek()) {
                Integer maxHeapRoot = maxHeap.poll();
                Integer minHeapRoot = minHeap.poll();
                maxHeap.add(minHeapRoot);
                minHeap.add(maxHeapRoot);
            }
        } else {
            minHeap.add(maxHeap.poll());
        }

        numOfElement++;
    }

    private int getMedia() {
        return maxHeap.peek();
    }
}
