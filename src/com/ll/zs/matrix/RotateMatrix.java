package com.ll.zs.matrix;

public class RotateMatrix {

    public static void rotateEdge(int[][] matrix, int tR, int tC, int dR, int dC){
        if((dR - tR) != (dC - tC)){
            throw new RuntimeException("Check your matrix's 'col = row'");
        }
        int times = dR - tR;
        int temp = 0;
        for(int i = 0; i < times; i++){
            temp = matrix[tR][tC + i];
            matrix[tR][tC + i] = matrix[dR - i][tC];
            matrix[dR - i][tC] = matrix[dR][dC - i];
            matrix[dR][dC - i] = matrix[tR + i][dC];
            matrix[tR + i][dC] = temp;
        }
    }

    public static void rotate(int[][]  matrix){
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while(tR < dR){
            rotateEdge(matrix,tR++,tC++,dR--,dC--);
        }
    }

    public static void printMatrix(int[][] m){
        for(int i = 0 ;i <= m.length - 1; i++){
            for(int j = 0; j <= m[0].length - 1; j++){
                System.out.print(m[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] m = {{1,2,3,4},{5,6,7,8},{9,10,11,12,13},{14,15,16,17}};
        printMatrix(m);
        rotate(m);
        System.out.println("=================");
        printMatrix(m);
    }
}
