package com.ll.zs.matrix;

//从内往外打印
public class PrintMatrixSpiralOrder2 {
    public static void printEdge(int arr[][],int tR,int tC,int dR,int dC){
        //如果只有一行 arr[1][n]
        if(tR == dR){
            while(tC != dC){
                System.out.print(arr[tR][tC++] + " ");
            }
        }
        //只有一列
        else if(tC == dC){
            while (tR != dR){
                System.out.print(arr[tR++][tC] + " ");
            }
        }
        //多行多列
        else{
            int curR=tR;
            int curC=tC;
            while(curR != dR){
                System.out.print(arr[curR++][tC] + " ");
            }
            while(curC != dC){
                System.out.print(arr[dR][curC++] + " ");
            }
            while(curR != tR){
                System.out.print(arr[curR--][dC] + " ");
            }
            while(curC != tC){
                System.out.print(arr[tR][curC--] + " ");
            }
        }
    }
    public static void spiralOrderPrint(int[][] arr){
        int tC = 0;
        int tR = 0;
        int dC = arr[0].length - 1;
        int dR = arr.length -1;
        while(tC <= dC && tR <= dR) {
            printEdge(arr, tR++, tC++, dR--, dC--);
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        spiralOrderPrint(arr);
    }
}
