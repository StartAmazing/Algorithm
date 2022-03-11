package com.ll.zs.msb.dp.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 去重
 */
public class GetAllSubSequenceII {
    public Set<String> res;
    public Set<String> getAllSubSequence(String s) {
        res = new HashSet<>();
        if (s.length() < 1) {
            res.add("");
            return res;
        }
        help(s.toCharArray(), 0, new StringBuilder());

        return res;
    }

    private void help(char[] chars, int curIdx, StringBuilder subStr){
        if (curIdx == chars.length) {
            res.add(subStr.toString());
            return;
        }
        StringBuilder sb1 = new StringBuilder(subStr).append(chars[curIdx]);
        StringBuilder sb2 = new StringBuilder(subStr);
        help(chars, curIdx + 1, sb1);
        help(chars, curIdx + 1, sb2);
    }

    public static void main(String[] args) {
        String str = "aaa";
        GetAllSubSequenceII dto = new GetAllSubSequenceII();
        Set<String> allSubSequence = dto.getAllSubSequence(str);
        System.out.println(allSubSequence);
    }
}
