package com.ll.lintcode.advance.chapter4.binarysearch;

/**
 * 实现 double sqrt(double x) 并且 x >= 0。
 * 计算并返回x开根后的值。
 *
 * 你不需要在意结果的精确度，我们会帮你输出结果。
 * 样例
 * 例1:
 *
 * 输入: n = 2
 * 输出: 1.41421356
 * 例2:
 *
 * 输入: n = 3
 * 输出: 1.73205081
 */
public class SqrtXII_586 {

    public double sqrt(double x) {
        double l = 0;
        double r = Math.max(x, 1.0);
        double eps = 1e-12;
        while (l + eps < r) {
            double mid = l + (r -l) / 2;
            if (mid * mid < x) {
                l = mid;
            } else {
                r = mid;
            }
        }

        return l;
    }

}
