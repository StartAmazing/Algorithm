package com.ll.lintcode.binarysearch;

/**
 * 给定一个包含 n 个整数的排序数组，找出给定目标值 target 的起始和结束位置。
 *
 * 如果目标值不在数组中，则返回[-1, -1]
 *
 * 样例
 * 例1:
 *
 * 输入:
 * []
 * 9
 * 输出:
 * [-1,-1]
 *
 * 例2:
 *
 * 输入:
 * [5, 7, 7, 8, 8, 10]
 * 8
 * 输出:
 * [3, 4]
 * 挑战
 * 时间复杂度 O(log n)
 */
public class SearchForARange_61 {

    public int[] searchRange(int[] A, int target) {
        int[] res = new int[]{-1,-1};
        if (A == null || A.length < 1){
            return res;
        }

        int start = 0;
        int end = A.length - 1;

        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(A[mid] < target){
                start = mid + 1;
            }else if(A[mid] == target){
                end = mid;
            }else {
                end = mid - 1;
            }
        }
        if(A[end] == target){
            res[0] = end;
        }
        if(A[start] == target){
            res[0] = start;
        }


        start = 0;
        end = A.length - 1;

        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(A[mid] < target){
                start = mid + 1;
            }else if(A[mid] == target){
                start = mid;
            }else {
                end = mid - 1;
            }
        }
        if(A[start] == target){
            res[1] = start;
        }
        if(A[end] == target){
            res[1] = end;
        }


        return res;
    }
}
