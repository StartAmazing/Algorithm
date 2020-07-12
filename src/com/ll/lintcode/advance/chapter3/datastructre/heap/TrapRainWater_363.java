package com.ll.lintcode.advance.chapter3.datastructre.heap;

/**
 * 给出 n 个非负整数，代表一张X轴上每个区域宽度为 1 的海拔图, 计算这个海拔图最多能接住多少（面积）雨水。
 *
 * Trapping Rain Water
 *
 * 样例
 * 样例 1:
 *
 * 输入: [0,1,0]
 * 输出: 0
 * 样例 2:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * 挑战
 * O(n) 时间, O(1) 空间
 *
 * O(n) 时间, O(n) 空间也可以接受
 */
public class TrapRainWater_363 {

    public int trapRainWater(int[] heights) {
        if (heights == null || heights.length < 2) {
            return 0;
        }
        int ans = 0;
        int left = 0, right = heights.length - 1;
        while (left < right) {
            int lIdx = left + 1;
            int rIdx = right - 1;
            if (heights[left] > heights[right]) {
                while (rIdx >= left && heights[rIdx] < heights[right]) {
                    ans += heights[right] - heights[rIdx--];
                }
                right = rIdx;
            } else {
                while (lIdx <= right && heights[lIdx] < heights[left]) {
                    ans += heights[left] - heights[lIdx++];
                }
                left = lIdx;
            }
        }

        return ans;
     }

}
