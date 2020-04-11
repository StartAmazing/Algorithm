package com.ll.lintcode.basic.greed;

/**
 * 给出一个非负整数数组，你最初定位在数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在那个位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 样例
 * 样例 1
 * <p>
 * 输入 : [2,3,1,1,4]
 * 输出 : 2
 * 解释 : 到达最后位置的最小跳跃次数是2(从下标0到1跳跃1个距离长度，然后跳跃3个距离长度到最后位置)
 */
public class JumpGameII_117 {

    //version 1: greed
    public int jump(int[] A) {
        if (A == null || A.length < 1) {
            return -1;
        }
        int count = 0;
        int satrtIdx = 0;
        int endIdx = 0;

        while (endIdx < A.length - 1) {
            int max = Integer.MIN_VALUE;
            for (int i = satrtIdx; i <= endIdx; i++) {
                if (max <= A[i] + i) {
                    max = A[i] + i;
                }
            }
            if (endIdx < max) {
                endIdx = max;
            } else {
                return -1;
            }
            count++;
        }
        return count;
    }

    //version 2: dynamic programming
    //the array f means the min times you can jump to the end
    public int jumpDp(int[] A) {
        if (A == null && A.length < 1) {
            return -1;
        }

        int len = A.length;

        int[] f = new int[len];
        f[len - 1] = 0;

        for (int i = len - 2; i >= 0; i--) {
            if (A[i] + i >= len - 1) {
                f[i] = 1;
            } else {
                int min = Integer.MAX_VALUE;
                for (int j = i + 1; j <= A[i] + i; j++) {
                    if (f[j] != 0 && min > f[j]) {
                        min = f[j];
                    }
                    if (min != Integer.MAX_VALUE) {
                        f[i] = min + 1;
                    } else {
                        f[i] = 0;
                    }
                }
            }
        }
        return f[0];
    }

    public static void main(String[] args) {
        JumpGameII_117 dto = new JumpGameII_117();
        int[] data = new int[]{5,9,3,2,1,0,2,3,3,1,0,0};
        dto.jumpDp(data);
    }

}
