package com.ll.leetcode;

import java.util.ArrayList;
import java.util.List;

//按照z字顺序打印字符串
public class ConvertWithZ {
    public static String solution(String str,int rowNum){
        if(rowNum < 2) return str;

        boolean goingDown = false;
        List<StringBuilder> rows = new ArrayList<>();
        for(int i = 0; i < Math.min(rowNum,str.length()) ; i++){
            rows.add(new StringBuilder());
        }

        int curRow = 0;

        for(char c : str.toCharArray()){
            rows.get(curRow).append(c);
            if(curRow == 0 || curRow == rowNum - 1)
                goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for(StringBuilder row : rows)
            ret.append(row);
        return ret.toString();
    }

    public static String solution2(String str,int numRows){
        if(numRows < 2) return str;

        StringBuilder ret = new StringBuilder();
        int n = str.length();
        int cycleLen = 2 * numRows - 2;

        for(int i = 0; i < numRows ; i++){
            for(int j = 0 ; j + i < n ; j += cycleLen){
                ret.append(str.charAt(j + i));
                if(i != 0 && i != numRows - 1 && j + cycleLen - i < n){
                    ret.append(str.charAt(j + cycleLen - i));
                }
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        String str = "LEETCODEISHIRING";
        String solution = solution(str, 3);
        System.out.println(solution);

        String solution2 = solution2(str, 3);
        System.out.println(solution2);

    }


}
