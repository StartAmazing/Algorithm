package com.ll.nine_chapter.advance.a_follow_up;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
        if(source.length() < target.length()) {
            return "";
        }

        int[] sourceMap = new int[256];
        int[] targetMap = new int[256];

        initTargetMap(target, targetMap);
        int left = 0, right = 0;
        String res = "";
        while (right < source.length()) {
            while(!checkValid(sourceMap, targetMap) && right < source.length()) {
                sourceMap[source.charAt(right++)]++;
            }

            while (checkValid(sourceMap, targetMap)) {
                if (res.equals("")) {
                    res = source.substring(left, right);
                } else {
                    res = res.length() > right - left ? source.substring(left, right) : res;
                }
                sourceMap[source.charAt(left++)]--;
            }

        }

        return res;
    }

    private void initTargetMap(String s, int[] resMap) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            resMap[chars[i]]++;
        }
    }

    private boolean checkValid(int[] sourceMap, int[] targetMap) {
        for (int i = 0; i < 256; i++) {
            if(sourceMap[i] < targetMap[i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * @link https://www.lintcode.com/problem/386/
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        while(right < s.length()) {
            while(right < s.length() && map.keySet().size() < k) {
                map.putIfAbsent(s.charAt(right), 0);
                map.put(s.charAt(right), map.get(s.charAt(right)) + 1);
                right++;
            }

            while(right < s.length() && map.keySet().contains(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) + 1);
                right++;
            }

            res = Math.max(res, right - left);

            map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
            if(map.get(s.charAt(left)) == 0) {
                map.remove(s.charAt(left));
            }
            left++;
        }

        return res;
    }


    public static void main(String[] args) {
        TwoPointer dto = new TwoPointer();
        String source = "eqgkcwGFvjjmxutystqdfhuMblWbylgjxsxgnoh";
        String target = "abcdd";

        System.out.println(dto.lengthOfLongestSubstringKDistinct(source, 16));
    }
}
