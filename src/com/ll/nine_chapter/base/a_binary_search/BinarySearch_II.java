package com.ll.nine_chapter.base.a_binary_search;

/**
 * XXXXOOO型
 */
public class BinarySearch_II {

    /*
     * 1. Find first bad version
     *
     * 2. Search in a big sorted array
     *
     * 3. Find Minimum in rotated sorted array(first number <= last number)
     */
    public static int findMinimumInRotatedSortedArray(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= nums[end]) {
                end = mid;
            } else {
                start = mid;
            }
        }

        return nums[end] < nums[start] ? end : start;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{11, 21, 31, 41, 51};
        System.out.println(findMinimumInRotatedSortedArray(nums));
    }
}
