package com.ll;

public class SpeedTest {

    public static void copyArr1(int[][] src, int[][] dst) {
        if (src.length != dst.length || src[0].length != dst[0].length) {
            return;
        }

        int row = src.length, col = src[0].length;
        int i, j;
        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                dst[i][j] = src[i][j];
            }
        }
    }

    public static void copyArr2(int[][] src, int[][] dst) {
        if (src.length != dst.length || src[0].length != dst[0].length) {
            return;
        }

        int row = src.length, col = src[0].length;
        int i, j;
        for (j = 0; j < col; j++) {
            for (i = 0; i < row; i++) {
                dst[i][j] = src[i][j];
            }
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        copyArr1(new int[2048][2048], new int[2048][2048]);
        long endTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread() + "cosTime: " + (double)(endTime - startTime) / 1000 + "ms");
        startTime = System.currentTimeMillis();
        copyArr2(new int[2048][2048], new int[2048][2048]);
        endTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread() + "cosTime: " + (double)(endTime - startTime) / 1000 + "ms");
    }
}
