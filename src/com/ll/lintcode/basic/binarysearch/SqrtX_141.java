package com.ll.lintcode.basic.binarysearch;

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
        if (x  < 0){
            throw new IllegalArgumentException("x should greater than zero");
        }else if(x <= 1){
            return x;
        }
        int start = 1;
        int end = x;
        while ( start + 1 < end){
            int mid = start + (end - start) / 2;
            if (mid == x / mid){
                return mid;
            }else if (mid < x / mid){
                start = mid;
            }else{
                end = mid;
            }
        }

        return end > x / end ? start : end;

    }

    public static void main(String[] args) {
        SqrtX_141 dto = new SqrtX_141();
        dto.sqrt(1);

        System.out.println(46341 * 46341);
    }
}
