package com.ll.zs.msb.chapter1.monotonous_stack;

import com.ll.zs.msb.util.ArrayTools;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个【无重复元素】的数组nums，返回一个int[2][nums.length]的二维数组，其中int[0][n]为nums[n]左边比他小的第一个数，
 * nums[1][n]为右边比他小的第一个数
 *
 * 单调栈
 */
public class GetNearLess_II_x {

    public int[][] getNearLessRepeat(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new int[2][0];
        }

        // List<Integer> -> 放的是同样值的索引，位置积压到一起
        Stack<List<Integer>> stack = new Stack<>();
        int[][] res = new int[2][nums.length];
        for (int i = 0; i < nums.length; i++) {
            // 低 -> 顶， 小 -> 大
            while (!stack.isEmpty() && stack.peek().size() > 0 && nums[stack.peek().get(0)] > nums[i]) {
                List<Integer> curList = stack.pop();
                // 取位于下面位置的列表中最晚加入的那个
                Integer leftNearLess = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                for(Integer ele : curList ){
                    // 取位于下面位置的列表中最晚加入的那个
                    res[0][ele] = leftNearLess;
                    res[1][ele] = i;
                }
            }

            if (stack.isEmpty() || nums[stack.peek().get(stack.peek().size() - 1)] != nums[i]) {
                List<Integer> pushList = new LinkedList<>();
                pushList.add(i);
                stack.push(pushList);
            } else {
                stack.peek().add(i);
            }
        }

        while (!stack.isEmpty()) {
            List<Integer> curList = stack.pop();
            Integer leftNearLess = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
            for(Integer ele : curList) {
                res[1][ele] = -1;
                res[0][ele] = leftNearLess;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        GetNearLess_II_x dto = new GetNearLess_II_x();
        int[] data = new int[]{1, 3, 3, 4, 7, 2, 2, 3, 5};
        int[][] res = dto.getNearLessRepeat(data);
        ArrayTools.printMatrix(res);
    }
}
