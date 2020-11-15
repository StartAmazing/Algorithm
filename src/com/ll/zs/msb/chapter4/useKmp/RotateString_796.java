package com.ll.zs.msb.chapter4.useKmp;

/**
 * 给出定义，如果有字符串“123456”
 * 那么： 234561，
 *       345612，
 *       456123，
 *       561234，
 *       612345，
 * 这些词互为旋转词，给出两个字符串，判断是否互为旋转词
 *
 *
 * 给定两个字符串, A 和 B。
 *
 * A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。如果在若干次旋转操作之后，A 能变成B，那么返回True。
 *
 * 示例 1:
 * 输入: A = 'abcde', B = 'cdeab'
 * 输出: true
 *
 * 示例 2:
 * 输入: A = 'abcde', B = 'abced'
 * 输出: false
 * 注意：
 *
 * A 和 B 长度不超过 100。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RotateString_796 {

    // 暴力
    public boolean rotateString(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        if (s1.length() == 0) {
            return true;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int idx1 = 0;
        while (idx1 < chars1.length) {
            int idx2 = 0;
            int start = idx1;
            while (idx2 != s2.length()) {
                if (start == chars1.length) {
                    start = 0;
                }
                if (chars1[start] == chars2[idx2]) {
                    start++;
                    idx2++;
                } else {
                    break;
                }
                if (idx2 == chars2.length) {
                    return true;
                }
            }
            idx1++;
        }

        return false;
    }

    // append with kmp
    public boolean rotateString_2(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        if (s1.length() == 0) {
            return true;
        }

        return kmp(s1 + s1, s2) != -1;
    }

    private int kmp(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int[] next = getNext(chars2);
        int idx1 = 0, idx2 = 0;
        while (idx1 < chars1.length && idx2 < chars2.length){
            if(chars1[idx1] == chars2[idx2]) {
                idx1++;
                idx2++;
            } else if(next[idx2] != -1) {
                idx2 = next[idx2];
            } else {
                idx1++;
            }
        }


        return idx2 == s2.length() ? idx1 - idx2 : -1;
    }

    private int[] getNext(char[] chars) {
        if (chars == null || chars.length < 1) {
            return new int[]{};
        }
        int[] next = new int[chars.length];
        next[0] = -1;
        next[1] = 0;
        int cn = 0, idx = 2;
        while (idx < next.length) {
            if (chars[idx - 1] == chars[cn]) {
                next[idx++] = ++cn;
            } else if(next[cn] > 0) {
                cn = next[cn];
            } else {
                next[idx++] = 0;
            }
        }

        return next;
    }

    public static void main(String[] args) {
        RotateString_796 dto = new RotateString_796();
        String s1 = "abcde";
        String s2 = "abced";
        System.out.println(dto.rotateString(s1, s2));
    }
}
