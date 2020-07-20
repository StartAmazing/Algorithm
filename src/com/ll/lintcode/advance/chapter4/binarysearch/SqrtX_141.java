package com.ll.lintcode.advance.chapter4.binarysearch;

/**
 * 实现 int sqrt(int x) 函数，计算并返回 x 的平方根。
 *
 * 样例
 * 样例 1:
 * 	输入:  0
 * 	输出: 0
 *
 *
 * 样例 2:
 * 	输入: 3
 * 	输出: 1
 *
 * 	样例解释：
 * 	返回对x开根号后向下取整的结果。
 *
 * 样例 3:
 * 	输入: 4
 * 	输出: 2
 *
 *
 * 挑战
 * O(log(x))
 */
public class SqrtX_141 {

    public int sqrt(int x) {
        long start = 1;
        long end = x;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid <= x) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (end * end <= x) {
            return (int) end;
        }
        return (int) start;
    }

}
