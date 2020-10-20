package com.ll.zs.msb.chapter1.slidwindow;

import java.util.LinkedList;

/**
 * 给定一个整型数组arr和一个整数num,某个arr中的子数组subarray，如果想要达标，必须满足subarray中的最大值 - subarray中的
 * 最小值 <= num, 返回arr中达标子数组的个数
 */
public class AllLessNumSubarray_x {

    // 定义某个L R 锁定某个数组范围时为curArr
    // 1. 如果此时curArr数组达标， 那么该范围以内的所有子数组均达标
    // 2. 如果此时curArr数组不达标， 那么L R往两边（L-- , R++范围之外）的所有子数组均不达标
    // 本质上滑动窗口也是一类双指针问题
    public int allLessNumSubarray(int[] nums, int s) {
        // 两个双端队列，一个维护最大值，一个维护最小值
        // 窗口一直成长直到不达标的位置，这样可以得到从L到R个子数组达标
        // L 和 R不回头，时间复杂度为O(N)
        if (nums == null || nums.length < 1) {
            return 0;
        }
        // 窗口内最小值的更新结构
        LinkedList<Integer> qMax = new LinkedList<>();
        // 窗口内最大值的更新结构
        LinkedList<Integer> qMin = new LinkedList<>();
        int L = 0, R = 0, res = 0;
        // 注意这里的窗口是L  ... R  [L, R)
        // [0, 0） 窗口中无数
        // [0, 1） 窗口中有一个数
        while (L < nums.length) {   // L 是开头位置，尝试每一个开头
            // 如果此时窗口开头是L， 下面的while循环工作： R扩张到违规位置为止
            while (R < nums.length) {
                // 最小值端口
                while (!qMin.isEmpty() && nums[qMin.peekLast()] >= nums[R] ) {
                    qMin.removeLast();
                }
                qMin.offerLast(R);
                // 最大值端口
                while (!qMax.isEmpty() && nums[qMax.peekLast()] <= nums[R]) {
                    qMax.removeLast();
                }
                qMax.offerLast(R);
                if(nums[qMax.getFirst()] - nums[qMin.getFirst()] > s) {
                    break;
                }
                // R是第一个不达标的位置
                R++;
            }
            res += (R - L);

            // 过期元素判断
            if (!qMin.isEmpty() && qMin.peekFirst() == L) {
                qMin.pollFirst();
            }
            if (!qMax.isEmpty() && qMax.peekFirst() == L) {
                qMax.pollFirst();
            }

            L++;
        }

        return res;
    }
}
