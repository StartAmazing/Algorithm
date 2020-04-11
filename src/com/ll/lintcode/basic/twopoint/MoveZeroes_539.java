package com.ll.lintcode.basic.twopoint;

/**
 * 给一个数组 nums 写一个函数将 0 移动到数组的最后面，非零元素保持原数组的顺序
 * <p>
 * 样例
 * 例1:
 * <p>
 * 输入: nums = [0, 1, 0, 3, 12],
 * 输出: [1, 3, 12, 0, 0].
 * 例2:
 * <p>
 * 输入: nums = [0, 0, 0, 3, 1],
 * 输出: [3, 1, 0, 0, 0].
 * 注意事项
 * 1.必须在原数组上操作
 * 2.最小化操作数
 */
public class MoveZeroes_539 {

    private void moveZeroes(int[] nums) {
        int i = 0;
        while(i < nums.length && nums[i] != 0){
            i ++;
        }
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] == 0) {
               continue;
            }
            swap(nums, i, j);
            while (i < nums.length && nums[i] != 0){
                i++;
            }
        }

    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{0, 1, 0, 3, 12};
        MoveZeroes_539 dto = new MoveZeroes_539();
        dto.moveZeroes(ints);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }
}
