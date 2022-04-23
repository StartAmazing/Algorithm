package com.ll.nine_chapter.special_topic;

public class SearchA2DMatrix_II {

    /**
     *  give you a 2D matrix like this
     *  [1, 3, 5, 7]
     *  [2, 4, 7, 8]
     *  [3, 5, 9, 10]
     *
     *  find if it contains a target value, return its' times
     */
    public static int searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return 0;
        }

        int row = 0;
        int col = matrix[0].length - 1;
        int res = 0;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                row++;
                col--;
                res++;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }

        while (row < matrix.length) {
            if (matrix[row][0] == target) {
                res ++;
            }
            row ++;
        }

        while (col >= 0) {
            if (matrix[matrix.length - 1][col] == target) {
                res ++;
            }
            col--;
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {2, 4, 7, 8}, {3, 5, 9, 10}};
        System.out.println(searchMatrix(matrix, 5));
    }
}
