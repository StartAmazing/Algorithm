package com.ll.lintcode.basic.twopoint;

/**
 * 给出一个含有正整数和负整数的数组，重新排列成一个正负数交错的数组。
 *
 * 样例
 * 样例 1
 *
 * 输入 : [-1, -2, -3, 4, 5, 6]
 * 输出 : [-1, 5, -2, 4, -3, 6]
 * 解释 : 或者仍和满足条件的答案
 * 挑战
 * 完成题目，且不消耗额外的空间。
 *
 * 注意事项
 * 不需要保持正整数或者负整数原来的顺序。
 */
public class InterleavingPositiveAndNegativeNumbers_144 {
    public void rerange(int[] A) {
        if(A == null || A.length < 3) {
            return;
        }

        // 给正负数分堆，正数在前，负数在后
        int l = 0;
        int r = A.length - 1;
        while (l < r) {
            while (l < r && A[l] > 0) {
                l++;
            }
            while (l < r && A[r] < 0) {
                r--;
            }

            if (l < r) {
                swap(A, l, r);
            }
        }

        // 使得l指向第一个负数， r指向最后一个正数
        while (A[l] > 0) {
            l++;
        }
        while (A[r] < 0) {
            r--;
        }

        // 判断正数多还是负数多
        if(A.length - l > r + 1) {
            // 负数多
            l = A.length - 2;
            r = 0;
        } else if(A.length - l < r + 1) {
            // 正数多
            l = A.length - 1;
            r = 1;
        } else {
            // 正数和负数一样多
            r = 1;
            l = A.length - 2;
        }
        while (r < l) {
            swap(A, l, r);
            r += 2;
            l -= 2;
        }
    }

    private void swap(int[] A, int x, int y) {
        int tmp = A[x];
        A[x] = A[y];
        A[y] = tmp;
    }

    public static void main(String[] args) {
        InterleavingPositiveAndNegativeNumbers_144 dto = new InterleavingPositiveAndNegativeNumbers_144();
        int[] test = new int[]{-13,-8,-12,-15,-14,35,7,-1,11,27,10,-7,-12,28,18};
        dto.rerange(test);
    }

}
