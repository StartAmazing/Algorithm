package com.ll.lintcode.advance.chapter1.kth.matrix;


/**
 * 给定两个排好序的数组 A, B，定义集合 sum = a * b ，其中a来自A数组，b来自B数组，求 sum 中第k小的元素
 *
 * 样例
 * 样例1
 *
 * 输入:
 * a = [1, 7, 11]
 * b = [2, 4, 6]
 * k = 3
 * 输出: 7
 * 说明: 满足条件的所有的和有[3, 5, 7, 9, 11, 13, 13, 15, 17]，其中第三个是7.
 * 样例2
 *
 * 输入:
 * a = [1, 7, 11]
 * b = [2, 4, 6]
 * k = 4
 * 输出: 9
 * 说明: 满足条件的所有的和有[3, 5, 7, 9, 11, 13, 13, 15, 17]，其中第四个是9.
 * 样例3
 *
 * 输入:
 * a = [1, 7, 11]
 * b = [2, 4, 6]
 * k = 8
 * 输出: 15
 * 说明: 满足条件的所有的和有[3, 5, 7, 9, 11, 13, 13, 15, 17]，其中第八个是15.
 * 挑战
 * 挑战一下更小的时间复杂度做法：
 *
 * O(k log_{min(n,m,k)})O(klog
 * min(n,m,k)
 * ​
 *  ), nn 是A 数组的大小，mm是B 数组的大小
 * O((m+n)log_{maxValue})O((m+n)log
 * maxValue
 * ​
 *  ),maxValuemaxValue是 A 数组和 B 数组中的最大值
 */
public class KthSmallestProductInTwoPositiveElementArrays_x {
}
