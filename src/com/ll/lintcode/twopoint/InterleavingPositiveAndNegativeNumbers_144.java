package com.ll.lintcode.twopoint;

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
    /*
     * @param A: An integer array.
     * @return: nothing
     */
    public void rerange(int[] A) {
        if(A == null || A.length < 3){
            return;
        }
        int l = 0;
        int r = A.length - 1;
        while(l < r){
            while(l < r && A[l] > 0){
                l ++;
            }
            while(l < r && A[r] < 0){
                r --;
            }
            if(l < r){
                swap(A, l++, r--);
            }
        }

        if(A[l] > 0){
            l ++;
        }
        if(A[r] < 0){
            r --;
        }

        if(A.length - l < r + 1){
            //正数多
            swap(A, r, A.length - 1);
            r = A.length - 2;
            l = 0;
        }else if(A.length - l > r + 1){
            //负数多
            swap(A, 0, l);
            l = 2;
            r = A.length - 2;
        }else{
            l = 0;
            r = A.length - 1;
        }
        while(l < r){
            swap(A, l, r);
            l += 2;
            r -= 2;

        }
    }
    private void swap(int[] nums, int x, int y){
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    public static void main(String[] args) {
        InterleavingPositiveAndNegativeNumbers_144 dto = new InterleavingPositiveAndNegativeNumbers_144();
        int[] test = new int[]{-13,-8,-12,-15,-14,35,7,-1,11,27,10,-7,-12,28,18};
        dto.rerange(test);
    }

}
