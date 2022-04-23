package com.ll.nine_chapter.special_topic;

import java.util.Arrays;
import java.util.Collections;

public class RecoverRotatedSortedArray {

    /**
     *
     * @param nums an array like [4, 5, 1, 2, 3]
     *  [4, 5, 1, 2, 3]  -> [5, 4, 1, 2, 3] -> [5, 4, 3, 2, 1] -> [1, 2, 3, 4, 5]
     *
     *
     *  O(n) time
     *  O(1) space
     */
    public static void recoverRotatedSortedArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int start = 0, mid = 0;
        int end = nums.length - 1;
        while (mid < end) {
            if (nums[mid] > nums[mid + 1]) {
                reverse(nums, 0, mid);
                reverse(nums, mid + 1, end);
                reverse(nums, 0, end);
            }
            mid++;
        }
    }

    private static void reverse(int[] nums, int start, int end) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int left = start, right = end;
        while (left < right) {
            int tmp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        recoverRotatedSortedArray(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
