package com.ll.lintcode.advance.chapter3.datastructre.stack;

import java.util.Stack;

/**
 *
 * 给你一个二维矩阵，权值为False和True，找到一个最大的矩形，使得里面的值全部为True，输出它的面积
 *
 * 样例
 * 样例1
 *
 * 输入:
 * [
 * [1, 1, 0, 0, 1],
 * [0, 1, 0, 0, 1],
 * [0, 0, 1, 1, 1],
 * [0, 0, 1, 1, 1],
 * [0, 0, 0, 0, 1]
 * ]
 * 输出: 6
 * 样例2
 *
 * 输入:
 * [
 * [0,0],
 * [0,0]
 * ]
 * 输出: 0
 */
public class MaximalRectangle_510 {

    public int maximalRectangle(boolean[][] matrix) {
        if(null == matrix || matrix.length < 1) {
            return 0;
        }

        int maxArea = 0;
        int[] line = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!matrix[i][j]) {
                    line[j] = 0;
                } else {
                    line[j] += 1;
                }
            }

            maxArea = Math.max(maxArea, getMaxArea(line));
        }

        return maxArea;
    }

    private int getMaxArea(int[] line) {

        Stack<Integer> stack = new Stack<>();
        int maxRecArea = 0;
        for (int k = 0; k <= line.length; k++) {
            int curHeight = (k == line.length) ? -1 : line[k];
            while (!stack.isEmpty() && curHeight <= line[stack.peek()]) {
                Integer curNum = stack.pop();
                int height = line[curNum];
                int width = k - (stack.isEmpty()? -1 : stack.peek()) - 1;
                maxRecArea = Math.max(maxRecArea, height * width);
            }

            stack.push(k);
        }

        return maxRecArea;
    }

    public static void main(String[] args) {
        boolean[][] data = new boolean[][]{{true, true, false, false, true},
                                           {false, true, false, false, true},
                                           {false, false, true, true, true},
                                           {false, false, true, true, true},
                                           {false, false, false, false, true}};

        MaximalRectangle_510 dto = new MaximalRectangle_510();
        System.out.println(dto.maximalRectangle(data));
    }
}
