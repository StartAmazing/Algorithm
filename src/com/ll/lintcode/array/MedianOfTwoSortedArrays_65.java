package com.ll.lintcode.array;

/**
 * 两个排序的数组A和B分别含有m和n个数，找到两个排序数组的中位数，要求时间复杂度应为O(log (m+n))
 *
 *  通过O(1)的时间把n规模的问题变为n/2规模的问题
 *  median是两个数组中的第(n + m) / 2 个数        findKth((m + n) / 2)
 *  如果我不想考虑两个变量只想考虑一个变量的话会好做很多      findKth(k = (m + n) / 2)
 *  lintCode median
 *           Kth largest Element
 *  现在的任务变成寻找两个排序数组合并到一起之后从大到小的第k个数(k = (m + n) / 2)
 *
 *  举个例子，如果我在班上目前排名是第10名，除了努力学习外还可以让前面的五个人去其他班
 *  即这里的话就是扔掉k / 2个数，但是这里的话如果是A数组扔掉一些，B数组扔掉一些的话肯定做不到O(log (m + n))
 *  所以每次扔掉的数应该是比较小的一半
 *
 *  如何定义比较小的一半呢？
 *  即：
 *  K的前k / 2个数是A中的前k / 2个数比较小还是B中前k / 2个数比较小？
 *  比较A的第k / 2这个数 和 B的前k / 2个数，谁比较小就扔掉那个数组的前k / 2个数，这样保证不会扔掉我们要找的数。
 *  证明：假设将A和B两个数组进行归并的话，然后 k = k / 2
 *
 */
public class MedianOfTwoSortedArrays_65 {

    /**
     * @param A: An integer array
     * @param B: An integer array
     * @return a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int len = A.length + B.length;

        //奇偶性分开
        if (len % 2 == 1) {
            return findKth(A, 0, B, 0, len / 2 + 1);
        }
        return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2.0;
    }

    //find kth number of two sorted array with O(nlog n) time cost
    private static int findKth(int[] A, int A_start,
                               int[] B, int B_start,
                               int k) {
        if (A_start >= A.length) {
            return B[B_start + k - 1];
        }
        if (B_start >= B.length) {
            return A[A_start + k - 1];
        }
        if (k == 1) {
            return Math.min(A[A_start], B[B_start]);
        }

        //细节1： k / 2 - 1是因为数组下标从0开始，所以第 k / 2个数对应的数组下标为 k / 2 - 1
        //如果这里有一个数组的个数不够k / 2个数，将他的key作为最大值
        int A_key = A_start + k / 2 - 1 < A.length ? A[A_start + k / 2 - 1] : Integer.MAX_VALUE;
        int B_key = B_start + k / 2 - 1 < B.length ? B[B_start + k / 2 - 1] : Integer.MAX_VALUE;

        if(A_key < B_key){
            //细节2： 递归方法的最后一个参数是k - k / 2 是为了防止如果k 是奇数的时候遗漏掉一个数
            return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
        }else{
            return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
        }
    }
}
