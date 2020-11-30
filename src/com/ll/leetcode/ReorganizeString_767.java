package com.ll.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 *
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *
 * 示例 1:
 *
 * 输入: S = "aab"
 * 输出: "aba"
 * 示例 2:
 *
 * 输入: S = "aaab"
 * 输出: ""
 * 注意:
 *
 * S 只包含小写字母并且长度在[1, 500]区间内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorganize-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReorganizeString_767 {
    class Pair{
        public int times;
        public int idx;

        public Pair(int _time, int _idx) {
            this.idx = _idx;
            this.times = _time;
        }
    }
    public String reorganizeString(String S) {
        if (S == null || S.length() < 1) {
            return "";
        }
        int[] map = new int[26];
        char[] chars = S.toCharArray();
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p2.times - p1.times);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            map[chars[i] - 'a'] += 1;
            if (map[chars[i] - 'a'] >= (chars.length + 1) / 2 + 1) {
                return "";
            }
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] > 0) {
                pq.add(new Pair(map[i], i));
            }
        }
        if (pq.isEmpty()) {
            return "";
        }
        Pair out = pq.poll(), peek;
        while (!pq.isEmpty()) {
            sb.append((char) (out.idx + 'a'));
            peek = pq.poll();
            out.times -= 1;
            Pair tmp = out;
            out = peek;
            if (tmp.times > 0) {
                pq.add(tmp);
            }
        }
        sb.append((char) (out.idx + 'a'));

        return sb.toString();
    }

    public static void main(String[] args) {
        ReorganizeString_767 dto = new ReorganizeString_767();
        String data = "aaab";
        System.out.println(dto.reorganizeString(data));
    }
}
