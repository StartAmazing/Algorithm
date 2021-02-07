package com.ll.lintcode.advance.chapter1.twopoint.syntropy.window;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，找出最长子串TT的长度，它最多包含2个不同的字符。
 *
 * 样例
 * Example 1
 * Input: “eceba”
 * Output: 3
 * Explanation:
 * T is "ece" which its length is 3.
 * Example 2
 * Input: “aaa”
 * Output: 3
 */
public class LengthOfLongestSubstringTwoDistinct_928 {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() < 1) {
            return 0;
        }
        int L = 0, R = 0, res = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        while (R < chars.length) {
            while (map.size() > 2) {
                map.put(chars[L], map.get(chars[L]) - 1);
                if (map.get(chars[L]) == 0) {
                    map.remove(chars[L]);
                }
                L++;
            }

            if (!map.containsKey(chars[R])) {
                map.put(chars[R], 0);
            }
            map.put(chars[R], map.get(chars[R]) + 1);
            R++;
            if (map.size() <= 2) {
                res = Math.max(res, R - L);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstringTwoDistinct_928 dto = new LengthOfLongestSubstringTwoDistinct_928();
        int eceba = dto.lengthOfLongestSubstringTwoDistinct("a");
        System.out.println(eceba);
    }
}
