package com.ll.zs.msb.chapter3;

public class KMP_x {

    public int indexOf(String src, String match) {
        if (src == null || match == null || src.length() < match.length()) {
            return -1;
        }
        if ("".equals(match)) {
            return 0;
        }

        int[] next = getNext(match);  // next[i] 表示match中 i 位置之前最长的前缀和后缀相等的长度
        char[] srcChars = src.toCharArray();
        char[] matchChars = match.toCharArray();
        int sIdx = 0, mIdx = 0;
        while (sIdx < srcChars.length && mIdx < matchChars.length) {
            if (srcChars[sIdx] == matchChars[mIdx]) {
                sIdx++;
                mIdx++;
            } else {
                if (next[mIdx] >= 0) {  // 也可以写成 mIdx != 0;
                    mIdx = next[mIdx];
                } else {            // mIdx不能往前跳了
                    sIdx++; // mIdx == 0
                }
            }
        }

        return (mIdx == matchChars.length) ? (sIdx - mIdx) : -1;
    }


    private int[] getNext(String str) {
        char[] chars = str.toCharArray();
        int[] next = new int[chars.length + 1];
        next[0] = -1;
        next[1] = 0;
        int idx = 2, cn = 0;
        while (idx < chars.length) {
            if(chars[idx - 1] == chars[cn]) {
                next[idx++] = ++cn;
            } else if(cn > 0) {
                cn = next[cn];
            } else {
                next[idx++] = 0;
            }
        }

        return next;
    }
}
