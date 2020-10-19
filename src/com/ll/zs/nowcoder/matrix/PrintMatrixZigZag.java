package com.ll.zs.nowcoder.matrix;

public class PrintMatrixZigZag {
    public static void printMatrixZigZag(int[][] matrix){
        int aR = 0, aC = 0, bR = 0, bC = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean formap = false;
        while(aR != endR + 1){
            printLevel(matrix, aR, aC, bR, bC, formap);
            //一定要先判断aR的值，因为如果先判断aC的值，则aC的值会提前改变，再判断aR的值会出现错误
            aR = (aC == endC ? aR + 1 : aR);
            aC = (aC == endC ? aC : aC + 1);
            //一定要先判断bC的值，因为bC的值由bR的值决定
            bC = (bR == endR ? bC + 1 : bC);
            bR = (bR == endR ? bR : bR + 1);
            formap = !formap;
        }

    }

    public static void printLevel(int[][] m, int aR, int aC, int bR, int bC, boolean f){
        if(f){
            while(aR != bR + 1){
                System.out.print(m[aR++][aC--] + " ");
            }
            System.out.println();
        }else{
            while(bR != aR - 1){
                System.out.print(m[bR--][bC++] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] m = {{1,2,3,4,5,6,7},{8,9,10,11,12,13,14},{15,16,17,18,19,20,21}};
        printMatrixZigZag(m);
    }
}
