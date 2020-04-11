package com.ll.lintcode.basic.binarysearch;

/**
 * 写出一个高效的算法来搜索 m × n矩阵中的值。
 *
 * 这个矩阵具有以下特性：
 *
 * 每行中的整数从左到右是排序的。
 * 每行的第一个数大于上一行的最后一个整数。
 * 样例
 * 样例  1:
 * 	输入: [[5]],2
 * 	输出: false
 *
 * 	样例解释:
 *   没有包含，返回false。
 *
 * 样例 2:
 * 	输入:
 * [
 *   [1, 3, 5, 7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ],3
 * 	输出: true
 *
 * 	样例解释:
 * 	包含则返回true。
 *
 * 挑战
 * O(log(n) + log(m)) 时间复杂度
 */
public class SearchA2DMatrix_28 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1){
            return false;
        }

        int start = 0;
        int end = matrix[0].length - 1;

        for (int row = 0; row < matrix.length;  row ++){
            if(matrix[row][end] >= target){
                while(start + 1 < end){
                    int mid = start + (end - start) / 2;
                    if(matrix[row][mid] == target){
                        return true;
                    }else if(matrix[row][mid] < target){
                        start = mid + 1;
                    }else{
                        end = mid - 1;
                    }

                }
                return matrix[row][start] == target || matrix[row][end] == target;
            }
        }

        return false;
    }

}
