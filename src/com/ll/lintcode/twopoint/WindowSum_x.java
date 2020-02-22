package com.ll.lintcode.twopoint;

/**
 * 求一个数组中窗口大小为k的和数组
 */
public class WindowSum_x {
    private int[] windowSum(int[] nums, int k){
        if(nums.length < k){
            return null;
        }
        int[] res = new int[nums.length - 2];
        for(int i = 0, j = k - 1; j < nums.length; i ++, j ++){
            res[i] = 0;
            for (int m = i; m <= j; m ++){
                res[i] += nums[m];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        WindowSum_x dto = new WindowSum_x();
        int[] ints = dto.windowSum(new int[]{1, 2, 7, 8, 5}, 3);
        if (ints != null) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
        }else {
            System.out.println("there's no elements.");
        }

    }
}
