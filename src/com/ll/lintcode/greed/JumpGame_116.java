package com.ll.lintcode.greed;

/**
 * 给出一个非负整数数组，你最初定位在数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在那个位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能到达数组的最后一个位置。
 * <p>
 * 样例
 * 样例 1
 * <p>
 * 输入 : [2,3,1,1,4]
 * 输出 : true
 * 样例 2
 * <p>
 * 输入 : [3,2,1,0,4]
 * 输出 : false
 * 注意事项
 * 这个问题有两个方法，一个是贪心和 动态规划。
 * <p>
 * 贪心方法时间复杂度为O（N）。
 * <p>
 * 动态规划方法的时间复杂度为为O（n^2）。
 * <p>
 * 我们手动设置小型数据集，使大家可以通过测试的两种方式。这仅仅是为了让大家学会如何使用动态规划的方式解决此问题。如果您用动态规划的方式完成它，你可以尝试贪心法，以使其再次通过一次。
 */
public class JumpGame_116 {

    //version 1: greed
    public boolean canJump(int[] A) {
        if (A == null || A.length < 1) {
            return false;
        }

        int[] canJumpMax = new int[A.length];
        int maxIndex = 0;
        int jump = 0;

        for (int i = 0; i < A.length; i++) {
            canJumpMax[i] = i + A[i];
        }

        while (jump < canJumpMax.length && jump <= maxIndex) {
            if (maxIndex < canJumpMax[jump]) {
                maxIndex = canJumpMax[jump];
            }
            jump++;
        }


        return jump >= canJumpMax.length - 1;
    }

    //version 2: dynamic programming
    //array f means if the position could jump to end
    public boolean canJumpDp(int[] A) {
        if (A == null || A.length < 1) {
            return false;
        }
        boolean[] canToEnd = new boolean[A.length];
        canToEnd[A.length - 1] = true;
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] + i >= A.length - 1) {
                canToEnd[i] = true;
            } else {
                for (int j = i + 1; j <= A[i] + i; j++) {
                    if (canToEnd[j]) {
                        canToEnd[i] = true;
                        break;
                    }
                }
            }

        }

        return canToEnd[0];
    }

    public static void main(String[] args) {
        JumpGame_116 dto = new JumpGame_116();
        int[] data = new int[]{4, 6, 9, 5, 9, 3, 0};
        dto.canJumpDp(data);
    }
}
