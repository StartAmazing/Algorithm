package com.ll.nine_chapter.base.binary_search;

public class BaseBinarySearch {

    public static int findTargetPositionInSortArray(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return - 1;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (nums[start] == target) {
            return start;
        }

        if (nums[end] == target) {
            return end;
        }

        return -1;
    }

    public static int findFirstTargetPositionInSortArray(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return - 1;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                end = mid;
            } else if(nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (nums[start] == target) {
            return start;
        }

        if (nums[end] == target) {
            return end;
        }

        return -1;
    }

    public static int findLastTargetPositionInSortArray(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return - 1;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                start = mid;
            } else if(nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[end] == target) {
            return end;
        }

        if (nums[start] == target) {
            return start;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9, 9, 9, 11, 12, 12, 16, 17, 17, 17, 21, 23};
        System.out.println(findTargetPositionInSortArray(nums, 17));
        System.out.println(findFirstTargetPositionInSortArray(nums, 17));
        System.out.println(findLastTargetPositionInSortArray(nums, 17));
    }
}
