package com.ll.nine_chapter.base.f_two_pointers;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoPointerAlgorithm {
    /**
     * @link https://www.lintcode.com/problem/539/
     * @param nums: an integer array
     * @return: nothing
     */
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length < 2) {
            return;
        }
        int left = 0;
        int right = 0;

        while(left < nums.length && right < nums.length) {
            while(left < nums.length && nums[left] != 0) {
                left++;
            }

            right = left;

            while(right < nums.length && nums[right] == 0) {
                right++;
            }

            if(left < nums.length && right < nums.length) {
                swap(nums, left, right);
            }
        }

    }

    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }


    /**
     * @link https://www.lintcode.com/problem/415/
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        if(s == null || s.length() < 2) {
            return true;
        }

        char[] chars = s.toLowerCase().toCharArray();
        int left = 0, right = s.length() - 1;
        while(left < right) {
            while(left < right && !validChar(chars[left])) {
                left++;
            }
            while(left < right && !validChar(chars[right])) {
                right--;
            }

            if(left >= right) {
                break;
            }

            if(chars[left++] != chars[right--]) {
                return false;
            }
        }

        return true;
    }

    private boolean validChar(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    /**
     * https://www.lintcode.com/problem/1790/
     * @param str: An array of char
     * @param left: a left offset
     * @param right: a right offset
     * @return: return a rotate string
     */
    public String rotateString2(String str, int left, int right) {
        left = left % str.length();
        right = right % str.length();
        if(left > right) {
            return reverseLeftWords(str, left - right);
        } else {
            return reverseLeftWords(str, str.length() - (right - left));
        }
    }

    /**
     * @link https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
     */
    private String reverseLeftWords(String s, int n) {
        n = n % s.length();
        char[] chars = s.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, s.length() - 1);
        reverse(chars, 0, s.length() - 1);

        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while(start < end) {
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
    }


    /**
     * @link https://www.lintcode.com/problem/39/
     * @param nums: An integer array
     * @return: nothing
     */
    public void recoverRotatedSortedArray(List<Integer> nums) {
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

    private void reverseList(List<Integer> nums, int start, int end) {
        while (start < end) {
            int tmp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, tmp);
            start++;
            end--;
        }
    }

    /**
     * https://leetcode.cn/problems/two-sum/submissions/
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2) {
            return new int[]{-1, -1};
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }

}
