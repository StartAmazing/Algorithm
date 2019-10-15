package com.ll.zs.basic.class06.mytest;

/**
 * 给出一个二维数组，二维数组中的每个数都是正数
 * 要求从左上角走到右下角，每一步只能向右或者向下
 * 。沿途经过的数字要累加起来。返回最小的路径和
 */
public class getSmallNumFromMatrix {

    //从(i,j)出发，到达最右下角，最短路径和是多少（返回）？
    private static int proces1(int[][] matrix, int i, int j){
        int res = matrix[i][j];
        if(i == matrix.length -1  && j == matrix[0].length - 1){
            return res;
        }
        if(i == matrix.length - 1){       //在最后一行上
            return res + proces1(matrix, i, j + 1);
        }
        if(j == matrix[0].length - 1){
            return res + proces1(matrix, i + 1, j);
        }
        return res + Math.min(proces1(matrix,i, j + 1),proces1(matrix, i + 1, j));
    }

    public static void main(String[] args) {
          int[][] matrix = new int[][]{
                  {4,3,0,1},
                  {2,5,1,3},
                  {5,5,5,2}
          };
        int i = proces1(matrix, 0, 0);
        System.out.println(i);
    }

}
