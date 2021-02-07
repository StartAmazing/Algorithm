package com.ll.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 *
 * 注意：字符串长度 和 k 不会超过 104。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "ABAB", k = 2
 * 输出：4
 * 解释：用两个'A'替换为两个'B',反之亦然。
 * 示例 2：
 *
 * 输入：s = "AABABBA", k = 1
 * 输出：4
 * 解释：
 * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * 子串 "BBBB" 有最长重复字母, 答案为 4。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-repeating-character-replacement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CharacterReplacement_424 {

    public int characterReplacement(String s, int k) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int[] map = new int[26];
        int res = 0;
        char[] chars = s.toCharArray();
        int L = 0, hisMax = Integer.MIN_VALUE;
        for (int R = 0; R < chars.length; R++) {
            map[chars[R] - 'A']++;

            // 注意这里的窗口只会变大不会变小，当进入if条件之后，其实L++,最后的结果不会变，
            // 只有当curMax变得更大的时候，才不会进入if条件，从而影响res结果
            hisMax = Math.max(hisMax, map[chars[R] - 'A']);
            if((R - L + 1) - hisMax > k ) {
                map[chars[L++] - 'A']--;
            }
            res = Math.max(res, R - L + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        CharacterReplacement_424 dto = new CharacterReplacement_424();
        String data = "AABCABCCC";
        int i = dto.characterReplacement(data, 2);
        System.out.println(i);
    }
}
