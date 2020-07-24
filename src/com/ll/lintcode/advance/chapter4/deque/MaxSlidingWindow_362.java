package com.ll.lintcode.advance.chapter4.deque;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给出一个可能包含重复的整数数组，和一个大小为 k 的滑动窗口,
 * 从左到右在数组中滑动这个窗口，找到数组中每个窗口内的最大值。
 *
 * 样例
 * 样例 1:
 *
 * 输入:
 * [1,2,7,7,8]
 * 3
 * 输出:
 * [7,7,8]
 *
 * 解释：
 * 最开始，窗口的状态如下：`[|1, 2 ,7| ,7 , 8]`, 最大值为 `7`;
 * 然后窗口向右移动一位：`[1, |2, 7, 7|, 8]`, 最大值为 `7`;
 * 最后窗口再向右移动一位：`[1, 2, |7, 7, 8|]`, 最大值为 `8`.
 * 样例 2:
 *
 * 输入:
 * [1,2,3,1,2,3]
 * 5
 * 输出:
 * [3,3]
 *
 * 解释:
 * 最开始，窗口的状态如下： `[|1,2,3,1,2 | ,3]` , 最大值为`3`;
 * 然后窗口向右移动一位.`[1, |2,3,1,2,3]`, 最大值为 `3`;
 * 挑战
 * O(n)时间，O(k)的额外空间
 */
public class MaxSlidingWindow_362 {

    // 单调双端队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null) {
            return new int[]{};
        }

        int[] ans = new int[nums.length - k];
        int idx = 0;
        LinkedList<Integer> idxDeque = new LinkedList<>();
        while (idx <= nums.length - 1) {
            while (!idxDeque.isEmpty() && nums[idxDeque.getFirst()] <= nums[idx]) {
                idxDeque.pollFirst();
            }

            idxDeque.push(idx);
            if (idx - idxDeque.peekLast() >= k) {
                idxDeque.pollLast();
            }
            if (idx >= k - 1) {
                ans[idx - k + 1] = idxDeque.getLast();
            }
            idx++;
        }

        return ans;
    }

    public static void main(String[] args) {
        MaxSlidingWindow_362 dto = new MaxSlidingWindow_362();
        int[] data = new int[]{1, 2, 7, 7, 2};
        System.out.println(dto.maxSlidingWindow(data, 3));
    }
}
