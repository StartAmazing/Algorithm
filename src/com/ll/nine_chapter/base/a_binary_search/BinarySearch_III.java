package com.ll.nine_chapter.base.a_binary_search;

/**
 * Half half
 * 并无法找到一个条件，形成OOXX模型，但是可以根据判断，
 * 保留下有解的那一半或是去掉无解的另一半
 */
public class BinarySearch_III {
    /**
     * Maximum Number in Mountain sequence
     */
    public static int maximumNumberInMountainSequence(int[] nums) {
        if ( nums == null || nums.length < 1) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[mid + 1]) {
                start = mid;
            } else  {
                end = mid;
            }
        }

        return nums[end] > nums[start] ? end : start;
    }

    /**
     * Find Peak Element
     */
    public static int findPeakElement(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (nums[mid] > nums[mid - 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return nums[start] > nums[end] ? start : end;
    }

    /**
     * Search in rotated sorted array
     */
    public static int searchInRotatedSortedArray(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > nums[end]) {
                if(target < nums[mid] && target >= nums[start]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
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

    public static void main(String[] args) {
        int[] nums = new int[]{11, 22, 66, 55, 44, 33};
        System.out.println(maximumNumberInMountainSequence(nums));


        int[] num2 = new int[]{44, 55, 66, 77, 11, 22, 33};
        System.out.println(searchInRotatedSortedArray(num2, 15));
    }
}
