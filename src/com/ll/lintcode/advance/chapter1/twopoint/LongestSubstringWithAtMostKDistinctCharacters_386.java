package com.ll.lintcode.advance.chapter1.twopoint;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定字符串S，找到最多有k个不同字符的最长子串T。
 *
 * 样例
 * 样例 1:
 *
 * 输入: S = "eceba" 并且 k = 3
 * 输出: 4
 * 解释: T = "eceb"
 * 样例 2:
 *
 * 输入: S = "WORLD" 并且 k = 4
 * 输出: 4
 * 解释: T = "WORL" 或 "ORLD"
 * 挑战
 * O(n) 时间复杂度
 */
public class LongestSubstringWithAtMostKDistinctCharacters_386 {

    public int lengthOfLongestSubStringKDistinct(String s, int k){
        if (s == null || s.length() < k){
            return 0;
        }

        int maxLen = 0;
        int i, j = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (i = 0; i < s.length(); i ++){
            while (j < s.length()){
                if (map.containsKey(s.charAt(j))){
                    map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
                }else{
                    if (map.size() == k){
                        break;
                    }
                    map.put(s.charAt(j), 1);
                }
                j++;
            }

            maxLen = Math.max(maxLen, j - i);

            if (map.size() == k){
                if (map.get(s.charAt(i)) > 1){
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                }else{
                    map.remove(s.charAt(i));
                }
            }
        }

        return maxLen;
    }

}
