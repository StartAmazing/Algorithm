package com.ll.lintcode.basic.binarysearch;

/**
 * 假设有一个排序的按未知的旋转轴旋转的数组(比如，0 1 2 4 5 6 7 可能成为4 5 6 7 0 1 2)。给定一个目标值进行搜索，如果在数组中找到目标值返回数组中的索引位置，否则返回-1。你可以假设数组中不存在重复的元素。
 * <p>
 * 样例
 * 例1:
 * <p>
 * 输入: [4, 5, 1, 2, 3] and target=1,
 * 输出: 2.
 * 例2:
 * <p>
 * 输入: [4, 5, 1, 2, 3] and target=0,
 * 输出: -1.
 * 挑战
 * O(logN) 时间限制
 */
public class SearchInRotatedSortedArray_62 {

    public int search(int[] A, int target) {

        if(A == null || A.length < 1){
            return -1;
        }

        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (A[mid] == target){
                return mid;
            }
            if(A[start] < A[mid]){
                if (A[mid] >= target && A[start] <= target){
                    end = mid;
                }else{
                    start = mid;
                }
            }else{
                if (A[mid] <= target && A[end] >= target){
                    start = mid;
                }else{
                    end = mid;
                }
            }
        }

        if (A[start] == target){
            return start;
        }
        if (A[end] == target){
            return end;
        }

        return -1;
    }

}
