package com.ll.zs.msb.util;

public class ArrayTools {

    public static void printMatrix(int[][] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i ++) {
            if (i != 0) {
                System.out.print(" ");
            }
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
                if (j != arr[i].length - 1) {
                    System.out.print(", ");
                }
            }
            if (i != arr.length - 1) {
                System.out.println();
            } else {
                System.out.print("]");
            }
        }
    }
}
