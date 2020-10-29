package com.ll.zs.msb.chapter2;

/**
 * 斐波那契数列
 */
public class Fibonacci_x {
    public int fibonacci_1(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        return fibonacci_1(n - 1) + fibonacci_1(n - 2);
    }

    public int fibonacci_2(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int res = 1;
        int pre = 1;
        int tmp = 0;
        for (int i = 3; i <= n; i++) {
            tmp = res;
            res += pre;
            pre = tmp;
        }

        return res;
    }

    public int fibonacci_3(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        //[ 1, 1 ]
        //[ 1, 0 ]
        int[][] base = {{1, 1}, {1, 0}};
        int[][] res = maxtrixPower(base, n - 2);
        return res[0][0] + res[1][0];

    }

    private int[][] maxtrixPower(int[][] base, int p) {
        // res = 矩阵中的1，即左上<->右下对角线上的值为1，其余元素为0的单位矩阵
        int[][] res = new int[base.length][base[0].length];
        for (int i = 0; i < res.length; i++) {
            res[i][i] = 1;
        }

        int[][] tmp = base;
        for (; p !=0; p >>= 1) {
            // 如果右移的过程中最后一位是1的时候乘到最后的结果中
            if ((p & 1) != 0) {
                res = multiMatrix(res, tmp);
            }
            tmp = multiMatrix(tmp, tmp);
        }

        return res;
    }

    private int[][] multiMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] res = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix1[0].length; k++) {
                    res[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return res;
    }


    public static void main(String[] args) {
        Fibonacci_x dto = new Fibonacci_x();
        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        startTime = System.currentTimeMillis();
        int a = dto.fibonacci_1(45);
        endTime = System.currentTimeMillis();
        System.out.println("fibonacci 1 cost time: " + (endTime - startTime) + "ms");
        startTime = System.currentTimeMillis();
        int b = dto.fibonacci_2(45);
        endTime = System.currentTimeMillis();
        System.out.println("fibonacci 2 cost time: " + (endTime - startTime) + "ms");
        startTime = System.currentTimeMillis();
        int c = dto.fibonacci_3(45);
        endTime = System.currentTimeMillis();
        System.out.println("fibonacci 3 cost time: " + (endTime - startTime) + "ms");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
