package com.ll.lintcode.advance.chapter3.datastructre.stack;

import java.util.Stack;

/**
 * 给出一个表达式 s，此表达式包括数字，字母以及方括号。
 * 在方括号前的数字表示方括号内容的重复次数(括号内的内容可以是字符串或另一个表达式)，
 * 请将这个表达式展开成一个字符串。
 * <p>
 * 数字只能出现在“[]”前面。
 * <p>
 * 您在真实的面试中是否遇到过这个题？
 * 样例
 * 样例1
 * <p>
 * 输入: S = abc3[a]
 * 输出: "abcaaa"
 * 样例2
 * <p>
 * 输入: S = 3[2[ad]3[pf]]xyz
 * 输出: "adadpfpfpfadadpfpfpfadadpfpfpfxyz"
 * 挑战
 * 你可以不通过递归的方式完成展开吗？
 */
public class ExpressionExpand_575 {

    public String expressionExpand(String s) {
        if (null == s || s.length() < 1) {
            return "";
        }

        char[] chars = s.toCharArray();
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (!isRightBracket(chars[i])) {
                stack.push(chars[i]);
            } else {
                StringBuilder subAns = new StringBuilder();
                while (!isLeftBracket(stack.peek())) {
                    subAns.append(stack.pop());
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                    StringBuilder subNum = new StringBuilder();
                    while (!stack.isEmpty() && isNumber(stack.peek())) {
                        subNum.append(stack.pop());
                    }
                    if (!"".contentEquals(subNum)) {
                        int times = Integer.parseInt(subNum.reverse().toString());
                        String str = subAns.reverse().toString();
                        for (int j = 0; j < times; j++) {
                            for (int k = 0; k < subAns.length(); k++) {
                                stack.push(str.charAt(k));
                            }
                        }
                    }
                }
            }

        }

        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        return ans.reverse().toString();

    }

    private boolean isNumber(Character ch) {
        return '0' <= ch && ch <= '9';
    }

    private boolean isLeftBracket(Character ch) {
        return ch == '[';
    }

    private boolean isRightBracket(Character ch) {
        return ch == ']';
    }

    public static void main(String[] args) {
        String data = "3[2[ad]3[pf]]xyz";
        ExpressionExpand_575 dto = new ExpressionExpand_575();
        String s = dto.expressionExpand(data);
        System.out.println(s);
    }

}
