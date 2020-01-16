package com.ll.lintCode.array;

/**
 * 合并两个排序的整数数组A和B变成一个新的数组，将A合并到B数组中
 */
public class MergeSortedArray_64 {

    /**
     * @param A sorted integer array A which has m elements, but size of A  is m + n
     * @param m An integer, number of integer which need be sorted
     * @param B sorted integer array B which has n elements
     * @param n An integer
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n){
        int len = m + n - 1;
        while (m > 0 && n > 0){
            if(A[m - 1] > B[n - 1]){
                A[len--] = A[--m];
            }else{
                A[len--] = B[--n];
            }
        }
        while (n > 0){
            A[len--] = B[--n];
        }
    }


}
