package com.ll.lintcode.advance.chapter1.twopoint.syntropy.window;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请找出其中无重复字符的最长子字符串。
 *
 * 样例
 * 样例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 最长子串是 "abc".
 * 样例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 最长子串是 "b".
 * 挑战
 * O(n) 时间复杂度
 */
public class LongestSubStringWithoutRepeating_384 {

    public int lengthOfLongestSubstring(String s){
        if (s == null || s.length() < 1){
            return 0;
        }
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int j = 0;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++){
            while (set.contains(chars[i])){
                set.remove(chars[j ++]);
            }
            set.add(chars[i]);
            ans = Math.max(set.size(), ans);
        }
        return ans;
    }

    //version2 use an array
    public int lengthOfLongestSubStrings(String s){
        if (s == null || s.length() < 1){
            return 0;
        }
        int[] map = new int[256];
        int i, j = 0;
        int ans = 0;
        for(i = 0; i < s.length(); i ++){
            while (j < s.length() && map[s.charAt(j)] == 0){
                map[s.charAt(j ++ )] = 1;
                ans = Math.max(ans, j - i);
            }
            map[s.charAt(i)] = 0;
            if(j >= s.length()) {
                break;
            }
        }
        return ans;
    }
}
