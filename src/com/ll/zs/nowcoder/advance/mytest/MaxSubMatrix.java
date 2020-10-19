package com.ll.zs.nowcoder.advance.mytest;

import java.util.Stack;

/**
 * 求最大子矩阵的大小
 * 题目
 * 给定一个整型矩阵map，其中的值只有0和1两种，求其中全是1的所有矩形区域中
 * ，最大的矩形区域为1的数量
 * 例如：
 * 1 1 1 0
 * 其中，最大的矩形区域有3个1，所以返回3
 * 再如：
 * 1 0 1 1
 * 1 1 1 1
 * 1 1 1 0
 * 其中最大的矩形区域有6个1，所以返回6
 */
public class MaxSubMatrix {

    public static int maxRecSize(int[][] map){
        if(map == null || map.length == 0 || map[0].length == 0){
            return 0;
        }
        int maxArea = 0;
        int[] height = new int[map[0].length];
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j ++){
              height[j] = map[i][j] == 0 ? 0 : height[j] + 1;   //求下一个直方图的高度
            }
            maxArea = Math.max(maxRecFromBottom(height), maxArea);
        }

        return maxArea;
    }

    private static int maxRecFromBottom(int[] height){
        if(height == null || height.length == 0){
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<Integer>();        //单调栈
        for(int i = 0 ; i < height.length ; i++){       //遍历数组中每一个数
            while (!stack.isEmpty() && height[i] <= height[stack.peek()]){
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();        //左边界
                int curArea = (i - k - 1) * height[j];          //计算高为height[j]往左右扩的面积
                maxArea = Math.max(curArea,maxArea);
            }
            stack.push(i);
        }

        //栈中还存在元素
        while (!stack.isEmpty()){
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int curArea = height[j] * (height.length - k - 1);      //右边界都为height数组的长度
            maxArea = Math.max(curArea, maxArea);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,1,0,1},{1,1,1,1},{1,1,1,0}};
        System.out.println(maxRecSize(arr));
    }

}
