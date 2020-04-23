package com.ll.lintcode.dp.chapter4;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，判断字符串是否存在一个排列是回文排列。
 *
 * 样例
 * 样例1
 *
 * 输入: s = "code"
 * 输出: False
 * 解释:
 * 没有合法的回文排列
 * 样例2
 *
 * 输入: s = "aab"
 * 输出: True
 * 解释:
 * "aab" --> "aba"
 * 样例3
 *
 * 输入: s = "carerac"
 * 输出: True
 * 解释:
 * "carerac" --> "carerac"
 */
public class PalindromePartitioning_916 {

    public boolean canPermutePalindrome(String s) {
        char[] chars = s.toCharArray();
        Set<Character> helpSet = new HashSet<>();
        for (Character ch : chars){
            if (helpSet.contains(ch)){
                helpSet.remove(ch);
            }else{
                helpSet.add(ch);
            }
        }

        return helpSet.size() <= 1;
    }

}
