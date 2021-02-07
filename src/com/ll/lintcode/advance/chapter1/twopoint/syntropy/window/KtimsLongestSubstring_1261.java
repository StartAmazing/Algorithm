package com.ll.lintcode.advance.chapter1.twopoint.syntropy.window;

/**
 * 找出给定字符串的最长子串，使得该子串中的每一个字符都出现了至少k次，返回这个子串的长度。
 *
 * 样例
 * 样例1：
 *
 * 输入：
 * s = "aaabb", k = 3
 * 输出：
 * 3
 * 解释：
 * 最长子串为"aaa"，因为'a'重复了3次。
 * 样例2：
 *
 * 输入：
 * s = "ababbc", k = 2
 * 输出：
 * 5
 * 解释：
 * 最长子串为"ababb"，因为'a'重复了2次，同时'b'重复了3次。
 */
public class KtimsLongestSubstring_1261 {

    public int longestSubstring(String s, int k) {
        if(s == null || s.length() < 1) {
            return 0;
        }

        int[] map = new int[256];
        for (char ch : s.toCharArray()) {
            map[ch]++;
        }

        return 0;
    }
}
