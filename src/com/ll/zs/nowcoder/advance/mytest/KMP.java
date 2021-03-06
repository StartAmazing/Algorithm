package com.ll.zs.nowcoder.advance.mytest;

/**
 * JD面试题 abcabc | abc
 * Google面试题  12312321231...... 是否是由某个子串重复叠加得到
 */
public class KMP {
    public static int getIndexOf(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] chars1 = s.toCharArray();
        char[] chars2 = m.toCharArray();
        int[] next = getNextArray(chars2);
        int i1 = 0;
        int i2 = 0;
        while (i1 < s.length() && i2 < m.length()) {
            if (chars1[i1] == chars2[i1]) {
                i1++;
                i2++;
            } else {
                if (next[i2] == -1) {
                    i1 += 1;
                } else {
                    i2 = next[i2];
                }
            }
        }
        return i2 == chars2.length ? i1 - i2 : -1;
    }

    public static int[] getNextArray(char[] chars) {
        if (chars.length == 1) {
            return new int[-1];
        }
        int[] next = new int[chars.length];
        next[0] = -1;
        next[1] = 0;
        //从位置2 开始
        int i = 2;
        int cn = 0;
        while (i < next.length) {
            if (chars[i - 1] == chars[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }
}
