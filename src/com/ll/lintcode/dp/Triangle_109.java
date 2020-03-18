package com.ll.lintcode.dp;

/**
 * 给定一个数字三角形，找到从顶部到底部的最小路径和。每一步可以移动到下面一行的相邻数字上。
 * <p>
 * 样例
 * 样例 1
 * <p>
 * 输入下列数字三角形：
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 输出： 11
 * 解释： 从顶到底部的最小路径和为11 ( 2 + 3 + 5 + 1 = 11)。
 * 样例 2
 * <p>
 * 输入下列数字三角形：
 * [
 * [2],
 * [3,2],
 * [6,5,7],
 * [4,4,8,1]
 * ]
 * 输出： 12
 * 解释： 从顶到底部的最小路径和为12 ( 2 + 2 + 7 + 1 = 12)。
 * 注意事项
 * 如果你只用额外空间复杂度O(n)的条件下完成可以获得加分，其中n是数字三角形的总行数
 */
public class Triangle_109 {
    //version 1: dfs traverse O(2^n)
    private int best = Integer.MAX_VALUE;

    public int minimumTotal1(int[][] triangle) {
        if (triangle == null || triangle.length < 1) {
            return -1;
        }
        traverse(triangle, 0, 0, 0);
        return best;
    }

    private void traverse(int[][] triangle, int row, int col, int sum) {
        if (row == triangle.length) {
            if (sum < best) {
                best = sum;
            }
            return;
        }
        traverse(triangle, row + 1, col, sum + triangle[row][col]);
        traverse(triangle, row + 1, col + 1, sum + triangle[row][col]);
    }


    //version 2: dfs Divide Conquer O(2^n)
    public int minimumTotal2(int[][] triangle) {
        if (triangle == null || triangle.length < 1) {
            return -1;
        }
        return divideConquer(triangle, 0, 0);
    }

    private int divideConquer(int[][] triangle, int row, int col) {
        if (row == triangle.length) {
            return 0;
        }
        return triangle[row][col] + Math.min(divideConquer(triangle, row + 1, col),
                divideConquer(triangle, row + 1, col + 1));
    }

    //version 3: Divide Conquer + Memorization O
    public int minimumtotal3(int[][] triangle) {
        if (triangle == null || triangle.length < 1){
            return -1;
        }
        int len = triangle.length;

        int[][] hash = new int[len][len];
        //init hash
        for (int i = 0; i < len; i ++){
            for (int j = 0; j < len; j ++){
                hash[i][j] = Integer.MAX_VALUE;
            }
        }
        return divideConquerWithMemorization(triangle, 0, 0, hash);
    }
    //return minimum path from (x, y) to bottom
    private int divideConquerWithMemorization(int[][] triangle, int row, int col, int[][] hash){
        //row index from 0 to n-1
        int len = triangle.length;
        if (row == len) {
            return 0;
        }
        //if we already got the minimum path from(x, y) to bottom
        //just return it
        if (hash[row][col] != Integer.MAX_VALUE){
            return hash[row][col];
        }

        //set before return
        hash[row][col] = triangle[row][col] +
                Math.min(divideConquerWithMemorization(triangle, row + 1, col, hash),
                        divideConquerWithMemorization(triangle, row + 1, col + 1, hash));

        return hash[row][col];
    }


    //version 4: Dynamic Programming from bottom to top
    public int minimumtotal4(int[][] triangle) {
        if (triangle == null || triangle.length < 1) {
            return -1;
        }
        int len = triangle.length;
//        int[][] f = new int[len][len];
        int[] f = new int[len];

        // init last row of array f
        for (int i = 0; i < len; i++) {
//            f[len - 1][i] = triangle[len - 1][i];
            f[i] = triangle[len - 1][i];
        }

        for (int i = len - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
//                f[i][j] = triangle[i][j] + Math.min(f[i + 1][j], f[i + 1][j + 1]);
                f[j] = triangle[i][j] + Math.min(f[j], f[j + 1]);
            }
        }

//        return f[0][0];
        return f[0];
    }

    //version 5: Dynamic Programming from top to bottom
    public int minimumtotal5(int[][] triangle){
        if (triangle == null || triangle.length < 1){
            return -1;
        }

        int len = triangle.length;
        //状态数组
        int[][] f = new int[len][len];

        //初始化起点
        f[0][0] = triangle[0][0];

        //初始化三角形的左边和右边
        for (int i = 1; i < len ; i ++){
            f[i][0] = triangle[i][0] + f[i - 1][0];
            f[i][i] = triangle[i][i] + f[i - 1][i - 1];
        }

        //top to bottom
        for (int i = 1; i < len; i++){
            for (int j = 1; j < i; j ++){
                f[i][j] = triangle[i][j] + Math.min(f[i - 1][j - 1], f[i - 1][j]);
            }
        }

        int best = Integer.MAX_VALUE;
        for (int i = 0; i < len; i ++){
            if (best > f[len - 1][i]){
                best = f[len - 1][i];
            }
        }
        return best;
    }

    public static void main(String[] args) {
        Triangle_109 dto = new Triangle_109();
        int res = dto.minimumtotal3(new int[][]{{2}, {3, 4}, {6, 5, 7},{4,1,8,3}});
        System.out.println(res);

    }
}
