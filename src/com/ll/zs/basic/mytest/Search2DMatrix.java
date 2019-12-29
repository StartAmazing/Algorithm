package com.ll.zs.basic.mytest;

public class Search2DMatrix {
    /**
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        if(matrix[0] == null ||matrix[0].length == 0){
            return 0;
        }

        int count = 0;
        int indexx = 0;
        int indexy = matrix[0].length - 1;
        while(indexx < matrix.length && indexy >= 0){
            if(matrix[indexx][indexy] > target){
                indexy --;
            }else if(matrix[indexx][indexy] < target){
                indexx ++;
            }else{
                count ++;
                indexx ++;
                indexy --;
            }
        }
        return count;
    }
}
