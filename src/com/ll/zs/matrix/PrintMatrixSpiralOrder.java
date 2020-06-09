package com.ll.zs.matrix;

public class PrintMatrixSpiralOrder {
    public static void printEdge(int [][] m, int tR, int tC, int dR, int dC){
        if(tR == dR) {
            for (int i = tC ; i< dC ; i++){
                System.out.print(m[tR][i] + " ");
            }
        } else if(tC == dC) {
            for(int i = tR ; i < dR ; i++){
                System.out.print(m[i][tC] + " ");
            }
        } else {
            int curR = tR;
            int curC = tC;
            while(curC != dC) {
                System.out.print(m[tR][curC++] + " ");
            }
            while(curR != dR) {
                System.out.print(m[curR++][dC] + " ");
            }
            while(curC != tC) {
                System.out.print(m[dR][curC--] + " ");
            }
            while(curR != tR) {
                System.out.print(m[curR--][tC] + " ");
            }
        }
    }
    public static void spiralOrderPrint(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length -1;
        while(tR <= dR && tC <= dC){
            printEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    public static void main(String[] args) {
        int[][] m = {{1,2,3,2},{1,12,33,12},{6,4,5,9},{1,3,90,54},{7,8,45,3}};
        spiralOrderPrint(m);
    }

}
