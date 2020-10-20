package com.ll.zs.msb.chapter1.monotonous_stack;

import com.ll.zs.msb.util.ArrayTools;

import java.util.Stack;

/**
 * 给定一个【无重复元素】的数组nums，返回一个int[2][nums.length]的二维数组，其中int[0][n]为nums[n]左边比他小的第一个数，nums[1][n]为右边
 * 比他小的第一个数
 *
 * 单调栈
 */
public class GetNearLess_I_x {
    public int[][] getNearLessNoRepeat(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new int[2][0];
        }
        int[][] res = new int[2][nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                Integer cur = stack.pop();
                res[0][cur] = stack.isEmpty() ? - 1 : stack.peek();
                res[1][cur] = i;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            Integer cur = stack.pop();
            if (!stack.isEmpty()) {
                res[0][cur] = stack.peek();
            } else {
                res[0][cur] = -1;
            }
            res[1][cur] = -1;
        }

        return res;
    }

    public static void main(String[] args) {
        GetNearLess_I_x dto = new GetNearLess_I_x();
        int[] data = new int[]{1, 2, 4, 3, 0, 8, 7};
        int[][] nearLessNoRepeat = dto.getNearLessNoRepeat(data);
        ArrayTools.printMatrix(nearLessNoRepeat);
    }
}
