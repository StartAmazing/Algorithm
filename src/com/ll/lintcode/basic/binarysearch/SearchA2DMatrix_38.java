package com.ll.lintcode.basic.binarysearch;

/**
 * 写出一个高效的算法来搜索m×n矩阵中的值，返回这个值出现的次数。
 *
 * 这个矩阵具有以下特性：
 *
 * 每行中的整数从左到右是排序的。
 * 每一列的整数从上到下是排序的。
 * 在每一行或每一列中没有重复的整数。
 * 样例
 * 例1:
 *
 * 输入:
 * [[3,4]]
 * target=3
 * 输出:1
 * 例2:
 *
 * 输入:
 *     [
 *       [1, 3, 5, 7],
 *       [2, 4, 7, 8],
 *       [3, 5, 9, 10]
 *     ]
 *     target = 3
 * 输出:2
 * 挑战
 * 要求O(m+n) 时间复杂度和O(1) 额外空间
 */
public class SearchA2DMatrix_38 {

    public int searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1){
            return 0;
        }
        int row = matrix.length - 1;
        int col = 0;
        int count = 0;
        while (row >= 0 && col < matrix[0].length){
            if(matrix[row][col] == target){
                count ++;
                row --;
                col ++;
            }else if(matrix[row][col] > target){
                row --;
            }else{
                col ++;
            }
        }

        return count;
    }
}
