package com.ll.nine_chapter.advance.a_follow_up;

import java.util.HashSet;
import java.util.Set;

public class TwoPointer {

    /**
     * @link https://www.lintcode.com/problem/406/
     * @param nums: an array of integers
     * @param s: An integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        if(nums == null || nums.length < 1) {
            return -1;
        }

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        while(right < nums.length) {
            sum += nums[right];
            while (sum >= s) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left++];
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }

    /**
     * @link https://www.lintcode.com/problem/384
     * @param s: a string
     * @return: an integer
     */
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() < 1) {
            return 0;
        }

        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int maxLen = 1;
        while(right < chars.length) {
            while(right < chars.length && !set.contains(chars[right])) {
                set.add(chars[right++]);
                maxLen = Math.max(maxLen, right - left);
            }

            set.remove(chars[left++]);
        }

        return maxLen;
    }

    /**
     * @link https://www.lintcode.com/problem/32/
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window, return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        return "";
    }


    public static void main(String[] args) {
    }
}
