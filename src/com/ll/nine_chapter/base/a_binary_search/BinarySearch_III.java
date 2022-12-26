package com.ll.nine_chapter.base.a_binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    /**
     * @link https://www.lintcode.com/problem/39/
     * @param nums: An integer array
     * @return: nothing
     */
    public static void recoverRotatedSortedArray(List<Integer> nums) {
        if (nums == null || nums.size() < 2) {
            return;
        }

        int start = 0, end = nums.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums.get(mid) > nums.get(mid - 1)) {
                end = mid;
            } else {
                start = mid;
            }
        }

        int divide = nums.get(start) < nums.get(end) ? start : end;
        reverseList(nums, 0, divide - 1);
        reverseList(nums, divide, nums.size() - 1);

        Collections.reverse(nums);
    }

    private static void reverseList(List<Integer> nums, int start, int end) {
        while (start < end) {
            int tmp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, tmp);
            start++;
            end--;
        }
    }


    /**
     * @link: https://www.lintcode.com/problem/8/
     * @param s: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public static void rotateString(char[] s, int offset) {
        if(s == null || s.length < 2 || offset < 0) {
            return;
        }
        offset = s.length - offset % s.length;
        rotate(s, 0, offset - 1);
        rotate(s, offset, s.length - 1);
        rotate(s, 0, s.length - 1);
    }

    private static void rotate(char[] s, int start, int end) {
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        char[] chars = new char[]{'a', 'b', 'c', 'd', 'e', 'f'};
        rotateString(chars, 3);
    }
}
