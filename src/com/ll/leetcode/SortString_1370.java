package com.ll.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 给你一个字符串s，请你根据下面的算法重新构造字符串：
 *
 * 1 从 s中选出 最小的字符，将它 接在结果字符串的后面。
 * 2 从 s剩余字符中选出最小的字符，且该字符比上一个添加的字符大，将它 接在结果字符串后面。
 * 3 重复步骤 2 ，直到你没法从 s中选择字符。
 * 4 从 s中选出 最大的字符，将它 接在结果字符串的后面。
 * 5 从 s剩余字符中选出最大的字符，且该字符比上一个添加的字符小，将它 接在结果字符串后面。
 * 6 重复步骤 5，直到你没法从 s中选择字符。
 * 7 重复步骤 1 到 6 ，直到 s中所有字符都已经被选过。
 * 8 在任何一步中，如果最小或者最大字符不止一个，你可以选择其中任意一个，并将其添加到结果字符串。
 *
 * 请你返回将s中字符重新排序后的 结果字符串 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aaaabbbbcccc"
 * 输出："abccbaabccba"
 * 解释：第一轮的步骤 1，2，3 后，结果字符串为 result = "abc"
 * 第一轮的步骤 4，5，6 后，结果字符串为 result = "abccba"
 * 第一轮结束，现在 s = "aabbcc" ，我们再次回到步骤 1
 * 第二轮的步骤 1，2，3 后，结果字符串为 result = "abccbaabc"
 * 第二轮的步骤 4，5，6 后，结果字符串为 result = "abccbaabccba"
 * 示例 2：
 *
 * 输入：s = "rat"
 * 输出："art"
 * 解释：单词 "rat" 在上述算法重排序以后变成 "art"
 * 示例 3：
 *
 * 输入：s = "leetcode"
 * 输出："cdelotee"
 * 示例 4：
 *
 * 输入：s = "ggggggg"
 * 输出："ggggggg"
 * 示例 5：
 *
 * 输入：s = "spo"
 * 输出："ops"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 500
 * s只包含小写英文字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-decreasing-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortString_1370 {

    public String sortString(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        char[] chars = s.toCharArray();
        TreeMap<Character, Integer> map = new TreeMap<>();
        StringBuilder resSb = new StringBuilder();
        for (char ch : chars) {
            if (!map.containsKey(ch)) {
                map.put(ch, 0);
            }
            map.put(ch, map.get(ch) + 1);
        }
        boolean upFlag = true;
        while (!map.isEmpty()) {
            if (upFlag) {
                Character cur = map.firstKey();
                resSb.append(cur);
                map.put(cur, map.get(cur) - 1);
                if (map.get(cur) == 0) {
                    map.remove(cur);
                }
                while ((cur = map.higherKey(cur)) != null) {
                    map.put(cur, map.get(cur) - 1);
                    if (map.get(cur) == 0) {
                        map.remove(cur);
                    }
                    resSb.append(cur);
                }
            } else {
                Character cur = map.lastKey();
                resSb.append(cur);
                map.put(cur, map.get(cur) - 1);
                if (map.get(cur) == 0) {
                    map.remove(cur);
                }
                while ((cur = map.lowerKey(cur)) != null) {
                    map.put(cur, map.get(cur) - 1);
                    if (map.get(cur) == 0) {
                        map.remove(cur);
                    }
                    resSb.append(cur);
                }
            }

            upFlag = !upFlag;
        }

        return resSb.toString();
    }

    public static void main(String[] args) {
        SortString_1370 dto = new SortString_1370();
        String data = "aabacbcbcb";
        String s = dto.sortString(data);
        System.out.println(s);
    }
}
