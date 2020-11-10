package com.ll.leetcode;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NextPermutation_31 {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int i, j = -1, k ,peek, right = nums.length - 1;
        for (i = nums.length - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                j = i - 1;
                k = i;
                peek = i;
                int minDisMore = nums[i] - nums[j];
                while (i < nums.length) {
                    if(nums[i] > nums[j]) {
                        int dis = nums[i] - nums[j];
                        if (dis <= minDisMore) {
                            minDisMore = dis;
                            k = i;
                        }
                    }
                    i++;
                }
                swap(nums, j, k);
                while (peek < right) {
                    swap(nums, peek++, right--);
                }
                break;
            }
        }

        if (i == 0) {
            peek = 0;
            while (peek < right) {
                swap(nums, peek++, right--);
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;

    }

    public static void main(String[] args) {
        int[] data = new int[]{100,99,98,97,96,95};
        NextPermutation_31 dto = new NextPermutation_31();
        dto.nextPermutation(data);
        for (int datum : data) {
            System.out.print(datum + ", ");
        }
    }
}
