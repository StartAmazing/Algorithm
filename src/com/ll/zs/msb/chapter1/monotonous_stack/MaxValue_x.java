package com.ll.zs.msb.chapter1.monotonous_stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个只包含【正整数】的数组arr,arr中任何一个子数组subArray,一定可以计算出
 * (sub累加和) * (sub中的最小值)是什么，那么所有子数组中，这个值的最大是多少
 */
public class MaxValue_x {

    public int maxValue(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }

        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = arr[i] + prefixSum[i - 1];
        }

        int[][] nearLess = new int[2][arr.length];
        Stack<List<Integer>> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek().size() > 0 && arr[stack.peek().get(stack.peek().size() - 1)] > arr[i]) {
                List<Integer> curList = stack.pop();
                Integer leftNearLess = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                for (Integer ele : curList) {
                    nearLess[0][ele] = leftNearLess;
                    nearLess[1][ele] = i;
                }
            }

            if (stack.isEmpty() || arr[stack.peek().get(stack.peek().size() -1)] < arr[i]) {
                List<Integer> newList = new ArrayList<>();
                newList.add(i);
                stack.push(newList);
            } else {
                stack.peek().add(i);
            }
        }

        while (!stack.isEmpty()) {
            List<Integer> curList = stack.pop();
            Integer leftNearLess = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
            for (Integer ele : curList) {
                nearLess[0][ele] = leftNearLess;
                nearLess[1][ele] = -1;
            }
        }

        int ans = 0;
        for (int i = 0; i < prefixSum.length; i++) {
            int leftLess = nearLess[0][i];
            int rightLess = nearLess[1][i];
            if (leftLess != -1 && rightLess != -1) {
                int squareSum = prefixSum[rightLess - 1] - prefixSum[leftLess];
                ans = Math.max(ans, squareSum * arr[i]);
            } else {
                if (leftLess == -1 && rightLess == -1)  {
                    ans = Math.max(ans, prefixSum[prefixSum.length - 1] * arr[i]);
                } else if (leftLess == -1) {
                    ans = Math.max(ans, prefixSum[rightLess - 1] * arr[i]);
                } else {
                    ans = Math.max(ans, (prefixSum[prefixSum.length - 1] - prefixSum[leftLess]) * arr[i]);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        MaxValue_x dto = new MaxValue_x();
        int[] data = new int[]{1, 3, 2, 7, 4, 1, 8, 9};
        int i = dto.maxValue(data);
        System.out.println(i);
    }
}
