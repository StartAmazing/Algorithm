package com.ll.lintcode.advance.chapter3.datastructre.stack;

import java.util.Stack;

/**
 * 给出的n个非负整数表示每个直方图的高度，每个直方图的宽均为1，
 * 在直方图中找到最大的矩形面积。
 *
 * 样例
 * 样例 1:
 *
 * 输入：[2,1,5,6,2,3]
 * 输出：10
 * 解释：
 * 第三个和第四个直方图截取矩形面积为2*5=10。
 * 样例 2:
 *
 * 输入：[1,1]
 * 输出：2
 * 解释：
 * 第一个和第二个直方图截取矩形面积为2*1=2。
 */
public class LargestRectangleInHistogram_122 {

    public int largestRectangleArea(int[] height) {
        if (null == height || height.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i <= height.length; i++) {
            int cur = (i == height.length) ? -1 : height[i];
            while (!stack.isEmpty() && cur <= height[stack.peek()]) {
                int h = height[stack.pop()];
                // 如果此时栈为空，说明直方图中前面元素的高度都比当前柱状图高度要高，所以宽度就是i,如果不为空，那么找到左边第一个比他小的高度
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(h * w, max);
            }
            stack.push(i);
        }

        return max;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram_122 dto = new LargestRectangleInHistogram_122();
        int[] data = new int[]{2,1,5,6,2,3};
        System.out.println(dto.largestRectangleArea(data));
    }
}
