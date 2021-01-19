package com.ll.zs.msb.chapter1.slidwindow;

import java.util.LinkedList;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *  
 *
 * 提示：
 *
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSlidWindow_59 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length < k || k < 1) {
            return new int[]{};
        }

        // 注意双端队列中放的元素是元素在arr中的索引，因为后面要根据位置判断该元素是否 “过期”
        // head -> tail  大 -> 小
        // 双端队列中最多可以有 k 个元素
        LinkedList<Integer> dequeue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        //      “L”         和        “R”
        //       i - w + 1             i
        for (int R = 0; R < nums.length; R++) {
            while (!dequeue.isEmpty() && nums[dequeue.getLast()] <= nums[R]) {
                dequeue.removeLast();
            }
            dequeue.addLast(R);
            if (dequeue.getFirst() < R - k + 1) {
                dequeue.removeFirst();
            }

            // 形成窗口之前不进行更新
            if (R - k + 1 >= 0) {
                res[R - k + 1] = nums[dequeue.getFirst()];
            }
        }
        return res;
    }


    public int[] slidWindow(int[] nums, int k) {
        if(nums == null || nums.length < k) {
            return new int[]{};
        }

        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> deque = new LinkedList<>();
        int left = 0, right = 0;
        while(right < nums.length) {
            while(!deque.isEmpty() && nums[deque.getLast()] <= nums[right]) {
                deque.removeLast();
            }

            deque.addLast(right);

            if(right - left + 1 == k) {
                res[left++] = nums[deque.getFirst()];
                if(left > deque.getFirst()) {
                    deque.removeFirst();
                }
            }
            right++;
        }
        return res;
    }
    
    public static void main(String[] args) {
        MaxSlidWindow_59 dto = new MaxSlidWindow_59();
        int[] data = new int[]{1,3,1,2,0,5};
        int[] res = dto.maxSlidingWindow(data, 3);
        int[] res2 = dto.slidWindow(data, 3);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + "  ");
        }
        System.out.println();
        for (int i = 0; i < res2.length; i++) {
            System.out.print(res2[i] + "  ");
        }
    }
}
